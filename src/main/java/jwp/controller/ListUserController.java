package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.JspView;
import core.mvc.view.View;
import java.util.AbstractList;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController extends AbstractController {
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        if(UserSessionUtils.isLogined(req.getSession())){
            ModelAndView mv = jspModelAndView("/user/list.jsp");
            mv.setAttribute("users", MemoryUserRepository.getInstance().findAll());

            return mv;
        }
        ModelAndView mv = jspModelAndView(REDIRECT + "/user/loginForm");

        return mv;
    }
}
