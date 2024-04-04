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

@WebServlet("/user/userList")
public class ListUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션에 저장된 정보 가져오기
        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");

        // 로그인되어있는 경우
        if (value != null) {
//            User user = (User) value; // Object 타입에서 User 타입으로 캐스팅

            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
            rd.forward(req, resp);
        } else { // 로그아웃되어있는 경우
            resp.sendRedirect("/user/login.jsp");
        }

    }

}
