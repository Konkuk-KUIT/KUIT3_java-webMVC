package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/update")
public class UpdateUserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        User user = new User(userId, name,password,email);
        MemoryUserRepository.getInstance().changeUserInfo(user);
        resp.sendRedirect("/user/userList");
    }

}
