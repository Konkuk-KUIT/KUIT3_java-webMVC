package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import core.mvc.view.View;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class ListUserController extends AbstractController {
    HttpSession session;

    @Override
    public ModelAndView execute(Map<String, String> params) {
        if (UserSessionUtils.isLogined(session)) {
            return jspView("/user/list.jsp")
                    .addObject("users", MemoryUserRepository.getInstance().findAll());
        }
        return jspView(REDIRECT_PREFIX + "/user/loginForm");
    }

    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }
}
