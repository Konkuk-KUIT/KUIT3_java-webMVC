package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvcFramework.Controller;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;

public class UpdateUserController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = new User(req.getParameter("userId"), req.getParameter("password"),req.getParameter("name"), req.getParameter("email"));
        MemoryUserRepository.getInstance().changeUserInfo(user);

        return REDIRCT+"/user/userList";
    }
}
