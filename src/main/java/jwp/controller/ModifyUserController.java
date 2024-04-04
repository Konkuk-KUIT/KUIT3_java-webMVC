package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.constants.URL;
import jwp.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyUserController implements Controller {

    @Override
    public Request execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));
        MemoryUserRepository.getInstance().findUserById(user.getUserId()).update(user);

        return new Request(Type.REDIRECT, URL.USER_LIST);
    }

}
