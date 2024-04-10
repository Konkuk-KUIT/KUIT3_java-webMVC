package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc_framework.Controller;
import jwp.model.User;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LoginController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp){

        HttpSession session = req.getSession();

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if(user.isSameUser(userId)){
            session.setAttribute("user", user);
            return "redirect:/";


        }
        return "/user/login_failed.jsp";

    }
}


