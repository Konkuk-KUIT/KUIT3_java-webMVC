package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.view.JSPView;
import core.mvc.view.View;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogInController extends AbstractController {
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User user = MemoryUserRepository.getInstance().findUserById(userId);

        if (user != null && user.isSameUser(userId, password)) {
            session.setAttribute("user", user);
            return new JSPView(REDIRECT + "/");
        }
        return new JSPView(REDIRECT + "/user/loginFailed");
    }
}