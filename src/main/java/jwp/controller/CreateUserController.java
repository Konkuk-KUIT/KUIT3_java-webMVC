package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserController extends AbstractController {
    @Override
    public ModelAndView execute(HttpServletRequest req) {
        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));

        MemoryUserRepository.getInstance().addUser(user);

        return jspView(REDIRECT + "/user/userList");
    }
}
