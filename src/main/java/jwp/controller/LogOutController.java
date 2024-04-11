package jwp.controller;

import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class LogOutController extends AbstractController {
    HttpSession session;
    @Override
    public ModelAndView execute(Map<String, String> params) {
        session.removeAttribute("user");
        return jspView("redirect:/");
    }

    @Override
    public void setSession(HttpSession httpSession) {
        this.session = httpSession;
    }
}