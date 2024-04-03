package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.util.UserSessionUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListUserController implements Controller {

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (UserSessionUtils.isLogined(req.getSession())) {
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());

            String viewPath = "/user/list.jsp";
            RequestDispatcher rd = req.getRequestDispatcher(viewPath);
            rd.forward(req,resp);
            return;
        }
        String viewPath = "/user/login.jsp";
        resp.sendRedirect(viewPath);
    }
}
