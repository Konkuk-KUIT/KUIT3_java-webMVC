package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc_framework.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class ListUserController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {


        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");
        if (value != null) {
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return "/user/list.jsp";
        }
        else{
            return "redirect:/";
        }
    }
}



//@WebServlet("/user/userList")
//public class ListUserController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//
//        HttpSession session = req.getSession();
//        Object value = session.getAttribute("user");
//        if (value != null) {
//            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
//            RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
//            rd.forward(req,resp);
//        }
//        else{
//            RequestDispatcher rd = req.getRequestDispatcher("/");
//            rd.forward(req,resp);
//        }
//    }
//}