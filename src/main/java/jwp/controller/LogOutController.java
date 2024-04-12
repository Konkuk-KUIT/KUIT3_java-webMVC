package jwp.controller;

import core.mvc.view.JSPView;
import core.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutController extends AbstractController {
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        return new JSPView(REDIRECT + "/");
    }
}