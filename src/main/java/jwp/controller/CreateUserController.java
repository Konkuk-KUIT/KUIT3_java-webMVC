package jwp.controller;

import core.db.MemoryUserRepository;

import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import jwp.controller.HTTPController;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet("/user/signup")
public class CreateUserController extends HTTPController {
    @Override
    protected ModelAndView doPost(HttpServletRequest req) throws ServletException, IOException {

        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));
        MemoryUserRepository.getInstance().addUser(user);


        return new ModelAndView( new JspView(REDIRECT+"/"));
    }
}
