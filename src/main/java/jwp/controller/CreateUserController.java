package jwp.controller;

import core.db.MemoryUserRepository;

import core.mvc_framework.Controller;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateUserController implements Controller{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User(req.getParameter("userId"), //getparameter :전달된 데이터저장
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));
        MemoryUserRepository.getInstance().addUser(user);

        return "/user/userList";
    }
}






















//@WebServlet("/user/signup")
//public class CreateUserController extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        User user = new User(req.getParameter("userId"),//getparameter :전달된 데이터저장
//                req.getParameter("password"),
//                req.getParameter("name"),
//                req.getParameter("email"));
//
//        MemoryUserRepository.getInstance().addUser(user);
//
//        resp.sendRedirect("/user/userList");
//    }
//}