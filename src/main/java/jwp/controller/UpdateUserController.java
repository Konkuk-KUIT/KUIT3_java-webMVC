package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import core.mvc.Controller;

public class UpdateUserController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("userId");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        User user = new User(userId, name,password,email);
        MemoryUserRepository.getInstance().changeUserInfo(user);
        return REDIRECT + "/user/userList";
    }

}
