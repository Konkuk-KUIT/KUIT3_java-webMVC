package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import jwp.model.User;
import jwp.util.UserSessionUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ListUserController extends HttpServlet implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 로그인되어있는 경우
        if (UserSessionUtils.isLogined(request.getSession())) {
            request.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return "/user/list.jsp";
        }
        return "redirect:/user/loginForm";
    }
}
