package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc_framework.Controller;
import jwp.model.User;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class UpdateUserFormController implements Controller  {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        String userId = req.getParameter("userId");
        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");
        if (value != null) {
            User userSession = (User) value;
            User user = MemoryUserRepository.getInstance().findUserById(userId);
            if (user.isSameUser(userSession)) {
                req.setAttribute("user", user);
                return "/user/updateForm.jsp";

            } else {
                return "/home.jsp";

            }

        }
        return "/home.jsp";
    }
}


