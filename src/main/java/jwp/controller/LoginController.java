package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static jwp.util.UserSessionUtils.USER_SESSION_KEY;

public class LoginController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        User loginUser = MemoryUserRepository.getInstance().findUserById(userId);

        // 가입되어있는 회원일 때
        if (loginUser != null && loginUser.isSameUser(userId, password)) {
            // 로그인 성공 시 세션 정보 저장
            session.setAttribute(USER_SESSION_KEY, loginUser);
            return "redirect:/";
        }
        return "redirect:/user/loginFailed";
//        resp.sendRedirect("/user/login_failed.jsp");
    }
}
