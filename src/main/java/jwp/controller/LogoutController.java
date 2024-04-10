package jwp.controller;

import jwp.constants.URL;
import jwp.mvc.view.ModelAndView;
import jwp.util.UserSessionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController extends AbstractController {

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        UserSessionUtil.logout(req.getSession());
        return getJspView(new Request(Type.REDIRECT, URL.HOME));
    }

}
