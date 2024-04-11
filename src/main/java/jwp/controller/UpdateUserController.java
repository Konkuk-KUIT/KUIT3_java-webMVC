package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import jwp.model.User;

import java.io.IOException;
import java.util.Map;

public class UpdateUserController extends AbstractController {

    @Override
    public ModelAndView execute(Map<String, String> paraMap) throws IOException {
        User user = new User(paraMap.get("userId"),
                paraMap.get("password"),
                paraMap.get("name"),
                paraMap.get("email"));

        MemoryUserRepository.getInstance().changeUserInfo(user);

        return jspView(REDIRECT + "/user/userList");
    }
}
