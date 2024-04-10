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

import static jwp.util.UserSessionUtils.getUserFromSession;
import static jwp.util.UserSessionUtils.isLogined;

public class UpdateUserFormController implements Controller{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response0) throws Exception {
        String id = request.getParameter("userId");

        if (isLogined(request.getSession())) {
            User user = getUserFromSession(request.getSession());
            if(user.getUserId().equals(id)){
                request.setAttribute("user", user);
                return "/user/updateForm.jsp";
            }
        }
        return "redirect:/user/userList";


    }
}