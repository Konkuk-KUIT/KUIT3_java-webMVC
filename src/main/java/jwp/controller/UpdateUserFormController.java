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

@WebServlet("/user/updateForm")
public class UpdateUserFormController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");

        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");

        if (value != null) {
            User user = (User) value;

            if(user.getUserId().equals(id)){
                req.setAttribute("user", user);
                RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
                rd.forward(req, resp);
            } else {
                resp.sendRedirect("/user/userList");
            }

            return;
        }

        resp.sendRedirect("/");




    }
}