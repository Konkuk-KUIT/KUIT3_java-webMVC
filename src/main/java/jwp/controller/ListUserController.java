package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.ModelAndView;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class ListUserController extends AbstractController {
    HttpSession session;

    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }
    @Override
    public ModelAndView execute(Map<String, String> paramMap) {

        if (UserSessionUtils.isLogined(session)) {

            ModelAndView mav = jspView("/user/list.jsp");
            mav.addModel("users", MemoryUserRepository.getInstance().findAll());
            return mav;
        }
        return jspView(REDIRECT + "/user/loginForm");
    }
}
