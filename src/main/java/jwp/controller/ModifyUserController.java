package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.constants.URL;
import jwp.model.User;
import jwp.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyUserController extends AbstractController {

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));
        MemoryUserRepository.getInstance().findUserById(user.getUserId()).update(user);

        return getJspView(new Request(Type.REDIRECT, URL.USER_LIST));
    }

}
