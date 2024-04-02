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
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Object value = session.getAttribute("user");
        User Loginuser = (User) value;
        User user = MemoryUserRepository.getInstance().findUserById(request.getParameter("userId"));
        if (user != null && user.getUserId().equals(Loginuser.getUserId())) {
            request.setAttribute("user", user);
            return "/user/updateForm.jsp";
        }
        return REDIRECT + "/";
    }
}
