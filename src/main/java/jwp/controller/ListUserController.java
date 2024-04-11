package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class ListUserController extends AbstractController {
    HttpSession session;
    @Override
    public ModelAndView execute(Map<String, String> params) {
        if(UserSessionUtils.isLogined(session)){
            return jspView("/user/list.jsp").addModel("users",MemoryUserRepository.getInstance().findAll());
        }

        return jspView("redirect:/user/loginForm");
    }

    @Override
    public void setSession(HttpSession httpSession) {
        this.session = httpSession;
    }
}
