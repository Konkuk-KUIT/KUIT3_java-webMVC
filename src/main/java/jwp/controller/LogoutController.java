package jwp.controller;

import jwp.constants.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController implements Controller {

    @Override
    public Request execute(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().removeAttribute("key");
        return new Request(Type.REDIRECT, URL.HOME);
    }

}
