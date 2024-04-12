package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.ModelAndView;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogInController extends AbstractController {
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User user = MemoryUserRepository.getInstance().findUserById(userId);

        if (user != null && user.isSameUser(userId, password)) {
            session.setAttribute("user", user);
            ModelAndView mav = jspView(REDIRECT + "/");
            mav.addModel("user", user);
            return mav;
        }
        return jspView(REDIRECT + "/user/loginFailed");
    }
}