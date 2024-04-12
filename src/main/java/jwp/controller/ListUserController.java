package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import core.mvc.view.JSPView;
import core.mvc.view.ModelAndView;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController extends AbstractController {
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        if(UserSessionUtils.isLogined(req.getSession())){
            ModelAndView model = new ModelAndView(new JSPView("/user/list.jsp"));
            model.addModel("users", MemoryUserRepository.getInstance().findAll());
            //req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return model;
        }
        return JSPView(REDIRECT + "/user/loginForm");
    }
}
