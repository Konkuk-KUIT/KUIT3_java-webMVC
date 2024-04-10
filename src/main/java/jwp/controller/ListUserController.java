package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.View;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ListUserController extends AbstractController {
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        if(UserSessionUtils.isLogined(req.getSession())){
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());

            Map<String,Object> map=new HashMap<>();
            map.put("users",MemoryUserRepository.getInstance().findAll());

            return jspView("/user/list.jsp",map);
        }

        return jspView(REDIRECT + "/user/loginForm",null);
    }
}
