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

public class UpdateUserFormController implements Controller {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user =getUserFromSession(request);
        if (user == null) {
            return "/";
        }
        if (sameUser(request))
            return "/user/updateForm.jsp";

        return "redirect:/user/userList";
    }

    public User getUserFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user == null)
            return null;

        return (User) user;
    }

    public boolean sameUser(HttpServletRequest request) {

        User sessionUser = getUserFromSession(request);

        String id = request.getParameter("userId");
        User user = MemoryUserRepository.getInstance().findUserById(id);

        return user.isSameUser(sessionUser);
    }
}
