package jwp.controller;

import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.AbstractController;
import core.mvc.view.JspView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutController extends AbstractController {
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.removeAttribute("user");

//        JspView jspView= new JspView(REDIRECT + "/");

        return jspView (REDIRECT + "/");
    }
}