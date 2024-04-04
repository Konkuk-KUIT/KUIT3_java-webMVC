package jwp.controller;

import core.db.MemoryUserRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jwp.model.User;

public class LoginController extends HttpController {

    @Override
    protected String doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if(user != null && user.matchPassword(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);     //TODO: Session Attribute
            return "redirect:/";
        }
        return "/user/login_failed.jsp";
    }
}
