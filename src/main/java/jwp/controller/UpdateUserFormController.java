package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.constants.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserFormController implements Controller{

    @Override
    public Request execute(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("userId");
        req.setAttribute("user", MemoryUserRepository.getInstance().findUserById(userId));

        return new Request(Type.FORWARD, JspPath.USER_UPDATE_FORM);
    }

}
