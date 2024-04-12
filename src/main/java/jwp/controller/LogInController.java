package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.model.User;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class LogInController extends AbstractController {
    private final MemoryUserRepository memoryUserRepository = MemoryUserRepository.getInstance();

    HttpSession session;
    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }


    @Override
    public ModelAndView execute(Map<String, String> params) {
        String userId = params.get("userId");
        String password = params.get("password");
        User user = memoryUserRepository.findUserById(userId);

        if (user != null && user.isSameUser(userId, password)) {
            session.setAttribute("user", user);
            return jspView(REDIRECT + "/");
        }
        return jspView(REDIRECT + "/user/loginFailed");
    }
}