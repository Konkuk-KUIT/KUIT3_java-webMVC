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

import static jwp.util.UserSessionUtils.isLogined;

public class ListUserController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response0) throws Exception {
        if(isLogined(request.getSession())){
            request.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return "/user/list.jsp";
        } else {
            return "redirect:/users/loginForm";
        }
    }
}
