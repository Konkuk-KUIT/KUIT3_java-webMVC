package jwp.controller;

import jwp.constants.URL;
import jwp.util.UserSessionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController implements Controller {

    @Override
    public Request execute(HttpServletRequest req, HttpServletResponse resp) {
        UserSessionUtil.logout(req.getSession());
        return new Request(Type.REDIRECT, URL.HOME);
    }

}
