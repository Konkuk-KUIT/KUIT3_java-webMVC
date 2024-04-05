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

import static jwp.util.UserSessionUtils.USER_SESSION_KEY;

@WebServlet("/user/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // URL에서 userId 파라미터 값 가져오기
        // 세션 데이터 삭제
        HttpSession session = req.getSession();
        session.removeAttribute(USER_SESSION_KEY);

        resp.sendRedirect("/");
    }
}
