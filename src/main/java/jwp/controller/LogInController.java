package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.JspView;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogInController extends AbstractController {
    @Override
    protected ModelAndView customExecute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        ModelAndView mav;

        if (user != null && user.isSameUser(userId, password)) {
            session.setAttribute("user", user);
            mav = jspView(REDIRECT + "/");
        } else {
            mav = jspView(REDIRECT + "/user/loginFailed");
        }
        return mav;
    }
}