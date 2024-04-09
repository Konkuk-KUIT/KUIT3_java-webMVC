package jwp.controller;

import core.db.MemoryUserRepository;

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
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userId=req.getParameter("userId");
        req.setAttribute("user", MemoryUserRepository.getInstance().findUserById(userId));
        return "/user/updateForm.jsp";
    }
}
