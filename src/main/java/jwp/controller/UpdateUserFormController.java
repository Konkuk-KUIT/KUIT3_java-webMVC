package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/updateForm")
public class UpdateUserFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentId = req.getParameter("userId"); // 쿼리파라미터에서 현재 수정하려는 userId를 가져옴
        User user = MemoryUserRepository.getInstance().findUserById(currentId); // currentId로 User객체를 찾아서 가져옴
        // user가 없는 경우가 아니면
        if(user != null){
            req.setAttribute("user", user);
            RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
            rd.forward(req, resp);
            return;
        }
        resp.sendRedirect("/");

    }
}
