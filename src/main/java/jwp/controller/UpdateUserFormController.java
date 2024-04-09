package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserFormController implements Controller{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MemoryUserRepository db = MemoryUserRepository.getInstance();
        User user = db.findUserById(request.getParameter("userId"));
        request.setAttribute("user", user);
        return "/user/updateForm.jsp";
    }
}
