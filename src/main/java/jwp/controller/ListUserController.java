package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.Util.LoginUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet("/user/userList")
public class ListUserController extends HTTPController {
    @Override
    protected String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
        HttpSession userSession = req.getSession(false);
        //String sessionId;
        if(!LoginUtil.isLogin(userSession)){
            return REDIRECT+"/user/login";
        }
        return "/user/list.jsp";
    }
}
