package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserController implements Controller{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        // 같은 아이디의 유저가 없으면 생성한다
        MemoryUserRepository repository = MemoryUserRepository.getInstance();
        if(repository.findUserById(req.getParameter("userId")) == null){
            User user = new User(req.getParameter("userId"),
                    req.getParameter("password"),
                    req.getParameter("name"),
                    req.getParameter("email"));

            MemoryUserRepository.getInstance().addUser(user);

            return "redirect:/user/userList";
        }
        return "redirect:/user/signupForm";
    }
}
