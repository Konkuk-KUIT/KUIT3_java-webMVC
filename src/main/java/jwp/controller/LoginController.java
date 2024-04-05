package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc_framework.Controller;
import jwp.model.User;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp){

        HttpSession session = req.getSession();

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if(user.isSameUser(userId)){
            session.setAttribute("user", user);
            return "redirect:/";


        }
        return "/user/login_failed.jsp";

    }
}


//@WebServlet("/user/login")
//public class LoginController extends HttpServlet{
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        HttpSession session = req.getSession();
//
//        String userId = req.getParameter("userId");
//        String password = req.getParameter("password");
//        User user = MemoryUserRepository.getInstance().findUserById(userId);
//        if(user.isSameUser(userId)){
//            session.setAttribute("user", user);
//            resp.sendRedirect("/");
//            return;
//
//        }
//        resp.sendRedirect("/user/login_failed.jsp");
//
//    }
//}