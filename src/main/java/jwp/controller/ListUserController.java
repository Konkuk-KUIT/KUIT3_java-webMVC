package jwp.controller;

import core.db.MemoryUserRepository;

import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import jwp.Util.LoginUtil;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet("/user/userList")
public class ListUserController extends HTTPController {
    @Override
    protected ModelAndView doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
        HttpSession userSession = req.getSession(false);
        //String sessionId;
        if(!LoginUtil.isLogin(userSession)){
            return new ModelAndView( new JspView(REDIRECT+"/user/login"));
        }
        return new ModelAndView( new JspView(REDIRECT+"/user/list.jsp"));
/*=======

public class ListUserController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        if(UserSessionUtils.isLogined(req.getSession())){
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return "/user/list.jsp";
        }
        return REDIRECT + "/user/loginForm";
>>>>>>> upstream/week4_step3-qna*/
    }
}
