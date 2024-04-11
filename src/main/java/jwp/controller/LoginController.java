package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import core.mvc.view.View;
import core.mvc.view.JspView;

public class LogInController implements Controller {
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User user = MemoryUserRepository.getInstance().findUserById(userId);

        if (user != null && user.isSameUser(userId, password)) {
            session.setAttribute("user", user);
//            return REDIRECT + "/";
            return new JspView(REDIRECT+"/");
        }
//        return REDIRECT + "/user/loginFailed";
        return new JspView(REDIRECT+"/user/loginFailed");
    }
}