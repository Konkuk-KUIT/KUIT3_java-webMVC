package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.ModelandView;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogInController implements Controller {
    @Override
    public ModelandView execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User user = MemoryUserRepository.getInstance().findUserById(userId);

        if (user != null && user.isSameUser(userId, password)) {
            session.setAttribute("user", user);
            return new JspView(REDIRECT + "/");
        }
        return new JspView(REDIRECT + "/user/loginFailed");
    }
}