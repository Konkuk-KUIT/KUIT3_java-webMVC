package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class ListUserController extends AbstractController {

    HttpSession session;
    @Override
    public void setSession(HttpSession httpSession) {
        this.session = httpSession;
    }

    @Override
    public ModelAndView execute(Map<String, String> paraMap) throws IOException {
        if(UserSessionUtils.isLogined(session)){
             ModelAndView mav = jspView("/user/list.jsp");
             mav.addModel("users",MemoryUserRepository.getInstance().findAll() );
//            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return mav;
        }
        return jspView(REDIRECT + "/user/loginForm");
    }
}
