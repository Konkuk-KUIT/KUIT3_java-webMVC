package jwp.controller;


import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/updateForm")
public class UpdateUserFormController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("userId");
        System.out.println("id = " + id);
        System.out.println("MemoryUserRepository.getInstance().findUserById(id).toString() = " + MemoryUserRepository.getInstance().findUserById(id).toString());
        req.setAttribute("user",MemoryUserRepository.getInstance().findUserById(id));

        RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
        rd.forward(req,resp);
    }

}
