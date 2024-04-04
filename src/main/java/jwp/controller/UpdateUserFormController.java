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

@WebServlet("/user/updateForm")
public class UpdateUserFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // URL에서 userId 파라미터 값 가져오기
        String paramUserId = req.getParameter("userId");

        // 현재 로그인되어있는 계정 확인 위함 아니면 /user/list로 redirect해야 함
        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");

        // 로그인되어있는 경우
        if(value!= null) {
            User loginUser = (User) value; // Object 타입에서 User 타입으로 캐스팅
            // 본인의 정보를 수정하는 경우
            if (loginUser.isSameUser(paramUserId)) {
                req.setAttribute("user", loginUser);
                RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
                rd.forward(req,resp);
            } else {
                resp.sendRedirect("/user/userList");
//                resp.sendError(HttpServletResponse.SC_FORBIDDEN, "본인의 정보만 수정 가능합니다.");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User updatedUser = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));

        MemoryUserRepository.getInstance().changeUserInfo(updatedUser);

        resp.sendRedirect("/user/userList");

    }
}
