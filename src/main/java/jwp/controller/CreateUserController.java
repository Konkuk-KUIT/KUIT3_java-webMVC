package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import jwp.model.User;

import java.io.IOException;
import java.util.Map;

public class CreateUserController implements Controller {
    @Override
    public ModelAndView execute(Map<String, String> params) throws IOException {
        User user = new User(params.get("userId"),
                params.get("password"),
                params.get("name"),
                params.get("email"));

        MemoryUserRepository.getInstance().addUser(user);

        // 리다이렉트를 위한 ModelAndView 객체 반환
        return ModelAndView.redirect("/user/userList");
    }
}
