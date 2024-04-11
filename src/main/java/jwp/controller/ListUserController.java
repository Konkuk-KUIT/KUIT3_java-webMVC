package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import core.mvc.view.View;
import core.mvc.view.JspView;

public class ListUserController implements Controller {
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) {
        if(UserSessionUtils.isLogined(req.getSession())){
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
//            return "/user/list.jsp";
            return new JspView("/user/list.jsp");
        }
//        return REDIRECT + "/user/loginForm";
        return new JspView("/user/loginForm");
    }
}