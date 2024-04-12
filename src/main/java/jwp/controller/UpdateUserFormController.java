package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.JspView;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserFormController extends AbstractController {
    @Override
    protected ModelAndView customExecute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userId = req.getParameter("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        ModelAndView mav;
        if (user != null) {
            mav = jspView("/user/updateForm.jsp");
            mav.addModel("user", user);
        } else {
            mav = jspView(REDIRECT + "/");
        }
        return mav;
    }
}