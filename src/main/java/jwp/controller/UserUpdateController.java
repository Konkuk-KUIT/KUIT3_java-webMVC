package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserUpdateController implements Controller{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        MemoryUserRepository repository = MemoryUserRepository.getInstance();
        User user = repository.findUserById(req.getParameter("userId"));
        // userId에 해당하는 유저의 값을 갱신한다.
        if(user != null){
            user.update(new User("", req.getParameter("password"), req.getParameter("name"), req.getParameter("email")));
        }
        return "redirect:/user/userList";
    }
}