package jwp.controller;

import core.db.MemoryUserRepository;
import core.servlet.Controller;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp){
        if (!UserSessionUtils.isLogined (req.getSession())) {
            return "redirect:/user/loginForm";
        }
        req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
        return "/user/list.jsp";
    }
}