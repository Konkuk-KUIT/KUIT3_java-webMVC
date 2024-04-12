package jwp.controller;

import core.mvc.AbstractController;
import core.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import core.mvc.ModelAndView;
import core.mvc.view.View;
import core.mvc.view.JspView;

public class LogOutController  extends AbstractController {
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
//        return REDIRECT + "/";
//        return new JspView(REDIRECT+"/");
        return jspView(REDIRECT+"/");
    }
}