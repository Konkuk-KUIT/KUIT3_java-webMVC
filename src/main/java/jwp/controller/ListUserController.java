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
    protected ModelAndView doGet(HttpServletRequest req) throws ServletException, IOException {
        //req.setAttribute("users", MemoryUserRepository.getInstance().findAll());

        HttpSession userSession = req.getSession(false);
        //String sessionId;
        if(!LoginUtil.isLogin(userSession)){
            return new ModelAndView( new JspView(REDIRECT+"/user/login"));
        }
        ModelAndView mv = new ModelAndView( new JspView("/user/list.jsp"));

        return mv.addModel("users", MemoryUserRepository.getInstance().findAll());

    }
}
