package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;
import jwp.util.UserSessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if (user != null && user.matchPassword(password)) {
            UserSessionUtils.login(session, user);
            resp.sendRedirect("/");
            return;
        }
        resp.sendRedirect("/user/login_failed.jsp");
    }
}
