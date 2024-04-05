package jwp.controller;

import core.mvc_framework.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class HomeController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp){
    return "/home.jsp";
    }
}



//@WebServlet("/")
//public class HomeController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");//경로 지정
//        rd.forward(req,resp);//해당 경로 페이지로 이동
//    }
//}