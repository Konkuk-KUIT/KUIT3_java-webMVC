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

@WebServlet("/user/login")
public class UserLoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = MemoryUserRepository.getInstance().findUserById(req.getParameter("userId"));
        System.out.println(user.getPassword());
        System.out.println(req.getParameter("password"));
        if(user != null && user.getPassword().equals(req.getParameter("password"))) { //로그인 성공
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("/");
        }
        else
            resp.sendRedirect("/user/login_failed.jsp");
    }
}
