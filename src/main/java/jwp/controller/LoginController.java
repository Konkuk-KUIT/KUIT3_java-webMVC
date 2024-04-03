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

@WebServlet("/user/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //user의 정보를 db에서 확인하고 login 여부 가리기
        User user = MemoryUserRepository.getInstance().findUserById(req.getParameter("userId"));
        if ((user != null)&&(user.getPassword().equals(req.getParameter("password"))) ){
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            //왜 foward로 하면 안될까?
            resp.sendRedirect("/");
        }else{
            resp.sendRedirect("/user/login_failed.jsp");
        }
    }
}
