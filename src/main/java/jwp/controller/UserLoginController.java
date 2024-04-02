package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLoginController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = MemoryUserRepository.getInstance().findUserById(request.getParameter("userId"));
        if(user != null && user.getPassword().equals(request.getParameter("password"))) { //로그인 성공
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return REDIRECT+"/";
        }
        else
            return REDIRECT+"/user/loginFailed";
    }
}
