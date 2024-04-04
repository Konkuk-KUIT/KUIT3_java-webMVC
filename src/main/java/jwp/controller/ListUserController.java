package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/userList")
public class ListUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if(user != null){
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
            rd.forward(req,resp);
            return;
        }
        resp.sendRedirect("/user/login.jsp");
    }
}
