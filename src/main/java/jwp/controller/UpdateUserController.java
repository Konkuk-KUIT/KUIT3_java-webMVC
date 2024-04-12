package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.view.JSPView;
import core.mvc.view.View;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserController extends AbstractController {
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));

        MemoryUserRepository.getInstance().changeUserInfo(user);

        return new JSPView(REDIRECT + "/user/userList");
    }
}
