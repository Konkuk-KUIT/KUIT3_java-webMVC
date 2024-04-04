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

@WebServlet("/user/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User loginUser = MemoryUserRepository.getInstance().findUserById(req.getParameter("userId"));

        if (loginUser != null) {
            // 로그인 성공 시 세션 정보 저장
            HttpSession session = req.getSession();
            session.setAttribute("user", loginUser);

            resp.sendRedirect("/");
        } else {
            resp.sendRedirect("/user/login_failed.jsp");
        }

    }
}
