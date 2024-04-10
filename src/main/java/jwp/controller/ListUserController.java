package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class ListUserController implements Controller{

    private static User getUserSession(HttpSession session) {
        Object user = session.getAttribute("user");
        if (user != null) {
            return (User) user;
        }
        return null;
    }

    private boolean isLogined(HttpSession session) {
        if (getUserSession(session) != null) {
            return true;
        }
        return false;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //session이 있으면 들여보내 주고 아니면 login으로 보내기
        HttpSession userSession = req.getSession();
        if(!isLogined(userSession)) {
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return "/user/list.jsp";
        }
        return "redirect:/user/loginForm";
    }
}
