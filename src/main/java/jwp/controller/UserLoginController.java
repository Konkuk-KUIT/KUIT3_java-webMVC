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
public class UserLoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));
        System.out.println(user.toString());
        MemoryUserRepository.getInstance().findUserById(user.getUserId()).update(user);*/
        User user=MemoryUserRepository.getInstance().findUserById(req.getParameter("userId"));

        if(user==null){
            resp.sendRedirect("/user/login_failed.jsp");
            return;
        }
        System.out.println(user.toString());
        if(!user.matchPassword(req.getParameter("password"))){
            resp.sendRedirect("/user/login_failed.jsp");
            return;
        }
        // 세션 정보 저장
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        resp.sendRedirect("/");
    }

    private void loginFailed(HttpServletResponse resp) throws IOException{
        resp.sendRedirect("/user/login_failed");
    }
}