package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class ListUserController extends AbstractController {
    private static final String LOGIN_FORM_PATH = "/user/loginForm";

    HttpSession session;
    @Override
    public void setSession(HttpSession httpSession) {
        this.session = httpSession;
    }

    @Override
    public ModelAndView execute(Map<String, String> params) {

        if (UserSessionUtils.isLogined(session)) {
            return JspView("/user/list.jsp").addModel("users", MemoryUserRepository.getInstance().findAll());
        } else {
            return ModelAndView.redirect(LOGIN_FORM_PATH);
        }
    }
}
