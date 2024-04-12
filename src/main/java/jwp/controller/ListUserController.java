package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import core.mvc.view.View;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController implements Controller {
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        if (UserSessionUtils.isLogined(req.getSession())) {
            return new ModelAndView(new JspView("/user/list.jsp"))
                    .addObject("users", MemoryUserRepository.getInstance().findAll());
        }
        return new ModelAndView(new JspView(REDIRECT_PREFIX + "/user/loginForm"));
    }
}
