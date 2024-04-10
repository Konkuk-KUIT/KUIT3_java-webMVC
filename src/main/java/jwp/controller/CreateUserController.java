package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.View;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class CreateUserController extends AbstractController {
    @Override
    public ModelAndView execute(Map<String, String> req) {
        User user = new User(req.get("userId"),
                req.get("password"),
                req.get("name"),
                req.get("email"));

        MemoryUserRepository.getInstance().addUser(user);

        return jspView(REDIRECT + "/user/userList");
    }
}
