package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc_framework.Controller;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class ListUserController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {


        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");
        if (value != null) {
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return "/user/list.jsp";
        }
        else{
            return "redirect:/";
        }
    }
}



