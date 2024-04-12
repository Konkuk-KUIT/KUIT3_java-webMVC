package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.view.JSPView;
import core.mvc.view.View;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController extends AbstractController {
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) {
        if(UserSessionUtils.isLogined(req.getSession())){
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return new JSPView("/user/list.jsp");
        }
        return new JSPView(REDIRECT + "/user/loginForm");
    }
}
