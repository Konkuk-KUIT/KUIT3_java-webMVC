package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.view.JsonView;
import core.view.JspView;
import core.view.View;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserFormController implements AbstractController {
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if (user != null) {
            req.setAttribute("user", user);
            return jspView( "/user/updateForm.jsp");
        }
        return jspView(REDIRECT + "/");
    }

    @Override
    public ModelAndView jspView(String url) {
        return new ModelAndView(new JspView(url));
    }

    public ModelAndView jsonView() {
        return new ModelAndView(new JsonView());
    }
}