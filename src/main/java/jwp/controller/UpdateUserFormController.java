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
import java.util.Map;

public class UpdateUserFormController extends AbstractController {
    @Override
    public ModelAndView execute(Map<String, String> params) {
        String userId = params.get("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if (user != null) {
            return JspView("/user/updateForm.jsp").addModel("user", user);
        }
        return ModelAndView.redirect("/");
    }
}