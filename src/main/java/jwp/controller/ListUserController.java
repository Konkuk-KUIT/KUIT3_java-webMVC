package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import jwp.util.UserSessionUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ListUserController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        // 로그인되어 있다면 리스트를 보여준다.
        if(session.getAttribute("user") != null){
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return "/user/list.jsp";
        }
        return "redirect:/";
    }
}
