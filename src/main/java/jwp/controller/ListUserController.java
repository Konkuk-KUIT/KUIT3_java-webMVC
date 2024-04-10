package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.View;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class ListUserController extends AbstractController {

    private HttpSession httpSession;

    @Override
    public ModelAndView execute(Map<String, String> req) {
        if(UserSessionUtils.isLogined(httpSession)){

            return jspView("/user/list.jsp")
                    .addModel("users",MemoryUserRepository.getInstance().findAll());
        }

        return jspView(REDIRECT + "/user/loginForm");
    }

    @Override
    public void setSession(HttpSession httpSession) {
        this.httpSession=httpSession;
    }
}
