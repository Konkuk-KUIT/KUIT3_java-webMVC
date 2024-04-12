package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class ListUserController extends AbstractController {
    private final MemoryUserRepository memoryUserRepository = MemoryUserRepository.getInstance();

    HttpSession session;

    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Override
    public ModelAndView execute(Map<String, String> params){
        if (UserSessionUtils.isLogined(session)) {
            return jspView("/user/list.jsp").addObject("users", memoryUserRepository.findAll());
        }
        return jspView(REDIRECT+"/user/loginForm");
    }
}
