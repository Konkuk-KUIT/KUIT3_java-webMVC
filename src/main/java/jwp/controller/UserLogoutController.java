package jwp.controller;

import core.db.MemoryUserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//@WebServlet("/user/logout")
public class UserLogoutController extends HTTPController {
    @Override
    protected String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //세션 데이터 삭제
        HttpSession session = req.getSession(false);
        if(session==null){
            //resp.sendRedirect("/");
            System.out.println("no session request logout ");
            return REDIRECT +"/";
        }
        session.removeAttribute("user");
        //resp.sendRedirect("/");
        return REDIRECT+ "/";
    }
}
