package jwp.controller;

import core.db.MemoryUserRepository;

import jwp.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateUserController extends HttpController {

    @Override
    protected String doPost(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("CALLED");
        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));

        MemoryUserRepository.getInstance().addUser(user);

        return "redirect:/user/userList";
    }

    @Override
    protected String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "/user/form";
    }
}
