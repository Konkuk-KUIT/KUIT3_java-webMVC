package jwp.controller;

import core.mvc.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class LogOutController extends AbstractController {
    HttpSession session;

    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Override
    public ModelAndView execute(Map<String,String> paramMap) {
        session.removeAttribute("user");
        return jspView(REDIRECT + "/");
    }
}