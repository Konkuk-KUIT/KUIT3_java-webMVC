package jwp.controller;

import core.db.MemoryUserRepository;
import core.db.Repository;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jwp.model.User;

public class UpdateUserFormController extends HttpController {
    private final Repository repository = MemoryUserRepository.getInstance();

    @Override
    protected String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");

        User user = repository.findUserById(id);
        HttpSession session = req.getSession();
        Object sessionUser = session.getAttribute("user");// TODO: Session Attribute
        if(sessionUser != user) {
            return "redirect:/user/userList";
        }
        req.setAttribute("user", user);

        return "/user/updateForm.jsp";
    }

    @Override
    protected String doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        User user = new User(userId, password, name, email);

        repository.changeUserInfo(user);

        return "redirect:/user/userList";
    }
}
