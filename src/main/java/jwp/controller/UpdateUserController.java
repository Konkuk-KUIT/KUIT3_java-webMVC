package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.model.User;

import java.util.Map;

public class UpdateUserController extends AbstractController {
    public ModelAndView execute(Map<String, String> params) {
        User user = new User(params.get("userId"),
                params.get("password"),
                params.get("name"),
                params.get("email"));

        MemoryUserRepository.getInstance().changeUserInfo(user);

        return jspView(REDIRECT + "/user/userList");
    }
}
