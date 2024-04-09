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
import core.mvc.Controller;

public class LoginController implements Controller{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        //로그인이 성공되면 세션에 정보 저장
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        // user 없으면 user에 null 반환
        if(user != null && user.isSameUser(password,userId)){
            HttpSession session = req.getSession();
            //세션 정보 저장
            session.setAttribute("user",user);
            return REDIRECT + "/";
        }
        return REDIRECT+ "/user/login_failed.jsp";
    }
}
