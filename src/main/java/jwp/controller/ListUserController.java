package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.JspView;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController extends AbstractController {
    private static final String LOGIN_FORM_PATH = "/user/loginForm";

    @Override
    public ModelAndView execute(HttpServletRequest req) {
        if (UserSessionUtils.isLogined(req.getSession())) {
            ModelAndView mav = JspView("/user/list.jsp");
            mav.addModel("users", MemoryUserRepository.getInstance().findAll());
            return mav;
        } else {
            return ModelAndView.redirect(LOGIN_FORM_PATH);
        }
    }
}
