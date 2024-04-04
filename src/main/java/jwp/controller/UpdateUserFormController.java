package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
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

        String userId = req.getParameter("userId");
        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");
        if (value != null) {
            User userSession = (User) value;
            User user = MemoryUserRepository.getInstance().findUserById(userId);
            if (user.isSameUser(userSession)) {
                req.setAttribute("user", user);
                RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
                rd.forward(req, resp);
            }
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
            rd.forward(req, resp);
        }

    }
}