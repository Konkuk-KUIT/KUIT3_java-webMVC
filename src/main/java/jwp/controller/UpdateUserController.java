package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.ModelAndView;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class UpdateUserController extends AbstractController {
    MemoryUserRepository userRepository = MemoryUserRepository.getInstance();
    @Override
    public ModelAndView execute(Map<String, String> paramMap) {
        User user = new User(paramMap.get("userId"),
                paramMap.get("password"),
                paramMap.get("name"),
                paramMap.get("email"));

        userRepository.changeUserInfo(user);
        ModelAndView mav = jspView(REDIRECT + "/user/userList");
        mav.addModel("user", user);
        return mav;
    }
}
