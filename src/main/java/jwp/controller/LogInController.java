package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class LogInController extends AbstractController {

    HttpSession session;
    @Override
    public ModelAndView execute(Map<String, String> params) {
        String userId = params.get("userId");
        String password = params.get("password");
        User user = MemoryUserRepository.getInstance().findUserById(userId);

        if (user != null && user.isSameUser(userId, password)) {
            session.setAttribute("user", user);
            return jspView("redirect:/");
        }
        return jspView("redirect:/user/loginFailed");
    }

    @Override
    public void setSession(HttpSession httpSession) {
        this.session = httpSession;
    }
}