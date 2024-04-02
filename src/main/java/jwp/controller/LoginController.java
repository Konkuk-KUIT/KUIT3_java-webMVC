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
        String userId=req.getParameter("userId");
        String password=req.getParameter("password");

        //유저 아이디 기반으로 유저 정보를 가져옴
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        //입력한 패스워드가 아이디로 찾은 유저의 비밀번호와 일치하는지 확인
        if(!user.matchPassword(password)){
            RequestDispatcher rd = req.getRequestDispatcher("/user/login_failed.jsp");
            rd.forward(req,resp);
        }
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        resp.sendRedirect("/");


    }
}
