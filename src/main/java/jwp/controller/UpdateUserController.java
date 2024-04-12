package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import core.mvc.view.View;
import core.mvc.view.JspView;


public class UpdateUserController extends AbstractController {
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));

        MemoryUserRepository.getInstance().changeUserInfo(user);

//        return REDIRECT + "/user/userList";
//            return new JspView(REDIRECT+"/user/userList");
        return jspView(REDIRECT+"/user/userList");
    }
}
