package jwp.controller;

import core.db.MemoryUserRepository;
import core.servlet.Controller;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserFormController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if (user == null) {
            return "redirect:" + "/";
        }
        req.setAttribute("user", user);
        return "/user/updateForm.jsp";
    }
}