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

public class LoginController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = MemoryUserRepository.getInstance().findUserById(req.getParameter("userId"));
        // 유저아이디와 패스워드가 올바르면 로그인을 한다.
        if(user != null && user.getPassword().equals(req.getParameter("password"))){
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            return "redirect:/";       // redirect인가?
        }
        return "/user/login_failed.jsp";
    }
}
