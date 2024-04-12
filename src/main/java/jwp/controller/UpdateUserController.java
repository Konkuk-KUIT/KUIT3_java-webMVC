package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import jwp.model.User;
import java.util.Map;

public class UpdateUserController extends AbstractController {
    @Override
    public ModelAndView execute(Map<String, String> params) {
        User user = new User(params.get("userId"),
                params.get("password"),
                params.get("name"),
                params.get("email"));

        MemoryUserRepository.getInstance().changeUserInfo(user);

        return ModelAndView.redirect("/user/userList");
    }
}
