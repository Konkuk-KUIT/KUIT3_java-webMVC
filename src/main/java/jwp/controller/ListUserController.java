package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.AbstractController;
import core.mvc.view.JspView;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController extends AbstractController {
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        if(UserSessionUtils.isLogined(req.getSession())){
//            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());

            JspView jspView= new JspView("/user/list.jsp");
            return new ModelAndView(jspView).addModel("users", MemoryUserRepository.getInstance().findAll());
        }
//        JspView jspView= new JspView(REDIRECT + "/user/loginForm");
        return  jspView(REDIRECT + "/user/loginForm");

    }
}
