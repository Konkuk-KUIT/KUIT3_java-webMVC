package jwp.controller;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class LogOutController extends AbstractController {

    HttpSession session;
    @Override
    public void setSession(HttpSession httpSession) {
        this.session = httpSession;
    }
    @Override
    public ModelAndView execute(Map<String, String> paraMap) throws IOException {
        session.removeAttribute("user");
        return jspView(REDIRECT + "/");
    }
}