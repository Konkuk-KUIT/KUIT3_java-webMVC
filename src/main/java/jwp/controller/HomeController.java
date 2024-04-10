package jwp.controller;


import core.db.MemoryUserRepository;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import core.mvc.view.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@WebServlet("/")
public class HomeController extends HTTPController {
    @Override
    protected ModelAndView doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
        modelAndView = new ModelAndView(new JspView("/index.jsp"));
        modelAndView.putModel("users", MemoryUserRepository.getInstance().findAll());
        return modelAndView;

    }
}
