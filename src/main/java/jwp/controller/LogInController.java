package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import jwp.model.User;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class LogInController extends AbstractController {


    HttpSession session;
    @Override
    public void setSession(HttpSession httpSession) {
        this.session = httpSession;
    }


    @Override
    public ModelAndView execute(Map<String, String> paraMap) {
        String userId = paraMap.get("userId");
        String password = paraMap.get("password");
        User user = MemoryUserRepository.getInstance().findUserById(userId);

        if (user != null && user.isSameUser(userId, password)) {
            session.setAttribute("user", user);
            return jspView(REDIRECT + "/");
        }
        return jspView(REDIRECT + "/user/loginFailed");
    }
}