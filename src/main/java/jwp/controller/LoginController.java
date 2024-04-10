package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.constants.JspPath;
import jwp.constants.URL;
import jwp.model.User;
import jwp.util.UserSessionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller {

    @Override
    public Request execute(HttpServletRequest req, HttpServletResponse resp) {
        String loginId = req.getParameter("userId");
        String pwd = req.getParameter("password");

        User user = MemoryUserRepository.getInstance().findUserById(loginId);
        if(user != null && user.getPassword().equals(pwd)) {
            UserSessionUtil.login(req.getSession(), loginId);
            return new Request(Type.REDIRECT, URL.HOME);
        }

        return new Request(Type.FORWARD, JspPath.USER_LOGIN_FAILED);
    }

}
