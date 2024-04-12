package jwp.controller;

import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import core.mvc.view.View;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class LogOutController extends AbstractController {
    HttpSession session;

    @Override
    public ModelAndView execute(Map<String, String> params) {
        session.removeAttribute("user");
        return jspView(REDIRECT_PREFIX + "/");
    }

    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }
}