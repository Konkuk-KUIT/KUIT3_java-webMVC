package jwp.controller;

import core.db.MemoryUserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//@WebServlet("/user/userList")
////public class ListUserController extends HttpServlet {
//    @Override
//    protected String doGet(HttpServletRequest req, HttpServletResponse resp) {
//        HttpSession session = req.getSession();
//        if (session.getAttribute("user") != null) {
//            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
//            RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
//            rd.forward(req, resp);
//            return;
//        }
//        resp.sendRedirect("/");
//    }
//}
public class ListUserController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        if(session.getAttribute("user") != null){
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return "/user/list.jsp";
        }
        return "redirect:/";
    }
}
