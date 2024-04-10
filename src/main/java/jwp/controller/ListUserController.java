package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.view.JsonView;
import core.view.JspView;
import core.view.View;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController implements AbstractController {
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        if(UserSessionUtils.isLogined(req.getSession())){
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return jspView( "/user/list.jsp");
        }
        return jspView(REDIRECT + "/user/loginForm");
    }

    @Override
    public ModelAndView jspView(String url) {
        return new ModelAndView(new JspView(url));
    }

    public ModelAndView jsonView() {
        return new ModelAndView(new JsonView());
    }
}
