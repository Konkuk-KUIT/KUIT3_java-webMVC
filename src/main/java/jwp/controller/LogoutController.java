package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
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

public class LogoutController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // URL에서 userId 파라미터 값 가져오기
        // 세션 데이터 삭제
        HttpSession session = request.getSession();
        session.removeAttribute(USER_SESSION_KEY);
        return "redirect:/";
    }
}
