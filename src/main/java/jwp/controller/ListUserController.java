package jwp.controller;

import core.db.MemoryUserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListUserController extends HttpController {
    @Override
    protected String doGet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");// TODO: Session Attribute
        if(user == null) {
            return "redirect:/user/login.jsp";
        }
        req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
        return "/user/list.jsp";
    }
}
