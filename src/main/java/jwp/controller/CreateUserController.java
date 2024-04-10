package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import core.view.JsonView;
import core.view.JspView;
import core.view.View;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserController implements Controller {
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));

        MemoryUserRepository.getInstance().addUser(user);

        return new JspView(REDIRECT + "user/userList");
    }
}
