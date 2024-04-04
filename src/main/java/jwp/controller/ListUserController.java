package jwp.controller;

import core.db.MemoryUserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

public class ListUserController extends HttpController {
    @Override
    protected String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");// TODO: Session Attribute
        if(user == null) {
            resp.sendRedirect("/user/login.jsp");
            return "redirect:/user/login.jsp";
        }
        req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
        return "/user/list.jsp";
    }
}
