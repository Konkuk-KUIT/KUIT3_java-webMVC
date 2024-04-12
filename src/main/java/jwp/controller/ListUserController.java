package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import core.mvc.view.View;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController extends AbstractController {
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        if(UserSessionUtils.isLogined(req.getSession())){
            ModelAndView mav = jspView("/user/list.jsp");
            mav.addModel("users", MemoryUserRepository.getInstance().findAll());
            return mav;
        }
        return jspView(REDIRECT + "/user/loginForm");
    }
}
