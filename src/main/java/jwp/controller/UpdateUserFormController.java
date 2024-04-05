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

@WebServlet("/user/updateForm")
public class UpdateUserFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 현재 로그인되어있는 계정 확인 위함
        HttpSession session = req.getSession();
        Object value = session.getAttribute(USER_SESSION_KEY);
        User loginUser = (User) value; // Object 타입에서 User 타입으로 캐스팅

        // 본인의 정보를 수정하는 경우
        if (loginUser.isSameUser(req.getParameter("userId"))) {
            req.setAttribute("user", loginUser);
            RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
            rd.forward(req,resp);
            return;
        }
        resp.sendRedirect("/user/userList");
    }
}
