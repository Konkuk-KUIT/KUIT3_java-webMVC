package jwp.controller;

import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class LogOutController extends AbstractController {
    HttpSession session;
    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Override
    public ModelAndView execute(Map<String, String> params) {
        session.removeAttribute("user");
        return jspView(REDIRECT + "/");
    }
}