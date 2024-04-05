package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//@WebServlet("/user/login")
public class UserLoginController extends HTTPController {

    @Override
    protected String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        return "/user/login.jsp";
    }
    @Override
    protected String doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=MemoryUserRepository.getInstance().findUserById(req.getParameter("userId"));
        if(user==null){
            //resp.sendRedirect("/user/login_failed.jsp");
            return loginFailed();
        }
        //System.out.println(user.toString());
        if(!user.matchPassword(req.getParameter("password"))){
            //resp.sendRedirect("/user/login_failed");
            return loginFailed();
        }
        // 세션 정보 저장
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        return REDIRECT +"/";
        //resp.sendRedirect("/");
    }

    private String loginFailed() throws IOException{
        //resp.sendRedirect("/user/login_failed");
        return REDIRECT +"/user/login_failed";
    }
}