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

public class LogInController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response0) throws Exception {
        String loginId = request.getParameter("userId");
        User user = MemoryUserRepository.getInstance().findUserById(loginId);


        if(user == null) return "/user/login_failed.jsp";


        if(user.getPassword().equals(request.getParameter("password"))){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "redirect:/";
        }

        return "/user/login_failed.jsp";
    }
}
