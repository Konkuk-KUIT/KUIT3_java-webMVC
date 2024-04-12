package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController extends AbstractController {
    @Override
    public ModelAndView execute(HttpServletRequest req) {
        if(UserSessionUtils.isLogined(req.getSession())){
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return jspView("/user/list.jsp");
        }
        return jspView(REDIRECT + "/user/loginForm");
    }
}
