package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.View;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class LogInController extends AbstractController {
    private HttpSession httpSession;
    @Override
    public ModelAndView execute(Map<String, String> req) {
        HttpSession session = httpSession;
        String userId = req.get("userId");
        String password = req.get("password");
        User user = MemoryUserRepository.getInstance().findUserById(userId);

        if (user != null && user.isSameUser(userId, password)) {
            session.setAttribute("user", user);

            return jspView(REDIRECT + "/");
        }
        return jspView(REDIRECT + "/user/loginFailed");

    }

    @Override
    public void setSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }
}