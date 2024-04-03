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


public class UpdateUserFormController implements Controller {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);

        String viewPath = "/user/updateForm.jsp";
        if (user != null) {
            req.setAttribute("user", user);
            RequestDispatcher rd = req.getRequestDispatcher(viewPath);
            rd.forward(req, resp);
            return;
        }
        resp.sendRedirect("/");
    }
}

