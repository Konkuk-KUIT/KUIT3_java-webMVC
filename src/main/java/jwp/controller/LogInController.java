package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.ModelAndView;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class LogInController extends AbstractController {

    MemoryUserRepository userRepository = MemoryUserRepository.getInstance();
    HttpSession session;

    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Override
    public ModelAndView execute(Map<String, String> paramMap) {

        String userId = paramMap.get("userId");
        String password = paramMap.get("password");
        User user = userRepository.findUserById(userId);

        if (user != null && user.isSameUser(userId, password)) {
            session.setAttribute("user", user);
            ModelAndView mav = jspView(REDIRECT + "/");
            mav.addModel("user", user);
            return mav;
        }
        return jspView(REDIRECT + "/user/loginFailed");
    }
}