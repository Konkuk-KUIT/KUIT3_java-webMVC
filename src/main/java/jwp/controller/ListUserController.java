package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.util.UserSessionUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/user/userList")
public class ListUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(UserSessionUtils.isLogined(request.getSession())){
            request.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            RequestDispatcher rd = request.getRequestDispatcher("/user/list.jsp");
            rd.forward(request,response);
            return;
        }
        response.sendRedirect("/user/login.jsp");

    }
}