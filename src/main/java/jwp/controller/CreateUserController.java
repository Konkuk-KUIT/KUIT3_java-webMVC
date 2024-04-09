package jwp.controller;

import core.db.MemoryUserRepository;

import jwp.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class CreateUserController implements Controller {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = new User(request.getParameter("userId"),
                request.getParameter("password"),
                request.getParameter("name"),
                request.getParameter("email"));

        MemoryUserRepository.getInstance().addUser(user);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "redirect:/user/userList";
    }
}
