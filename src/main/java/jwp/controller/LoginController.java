package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//html에 메서드는 post, action은 /user/login
//login시는 post방식, logout에서는 get방식
public class LoginController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        MemoryUserRepository repository = MemoryUserRepository.getInstance();

        HttpSession session = req.getSession(true);

        String id = req.getParameter("userId");
        String pw = req.getParameter("password");
        User user = repository.findUserById(id);

        if (user.isSameUser(id, pw) && user != null) {
            session.setAttribute("user", user);
            return "redirect:/";
        }
        return "redirect:/user/login_failed";
    }
}