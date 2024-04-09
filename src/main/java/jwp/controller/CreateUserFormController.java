package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserFormController implements Controller{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return "/user/form.jsp";
    }
}
