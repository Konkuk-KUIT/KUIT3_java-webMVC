package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;
import org.apache.catalina.users.MemoryUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class LogInController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션 정보
        HttpSession session = req.getSession();
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User user = MemoryUserRepository.getInstance().findUserById(userId);

        if (user != null && user.isSameUser(userId, password)) {
            // 세션 데이터 정보 저장
            session.setAttribute("user", user);
            resp.sendRedirect("/");
            return;

        }
        resp.sendRedirect("/user/login_failed.jsp");
    }
}
