package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserUpdateController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userId = req.getParameter("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        req.setAttribute("user", user);
        return "/user/updateForm.jsp";
    }
}
