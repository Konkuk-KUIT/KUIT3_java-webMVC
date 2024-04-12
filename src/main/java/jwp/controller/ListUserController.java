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
    @Override
    protected ModelAndView customExecute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ModelAndView mav;
        if(UserSessionUtils.isLogined(req.getSession())){
            mav = jspView("/user/list.jsp");
            mav.addModel("users", MemoryUserRepository.getInstance().findAll());
        } else {
            mav = jspView(REDIRECT + "/user/loginForm");
        }
        return mav;
    }
}
