package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvcFramework.Controller;
import jwp.model.User;

import javax.naming.ldap.Control;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        String userId = req.getParameter("userId");
        String userPw = req.getParameter("password");
        User user = MemoryUserRepository.getInstance().findUserById(userId);

        if(user != null && user.matchPassword(userPw) && user.isSameUser(userId)){ // 계정이 있는 경우
            session.setAttribute("user", user); // 세션에 user저장
            return REDIRCT+"/";
        }
        else{ // 로그인에 실패한 경우
            return REDIRCT+"/user/login_failed.jsp";
        }
    }
}
