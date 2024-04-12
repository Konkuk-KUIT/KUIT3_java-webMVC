package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.AbstractController;
import core.mvc.view.JspView;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserFormController extends AbstractController {
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if (user != null) {
//            req.setAttribute("user", user);
            JspView jspView= new JspView("/user/updateForm.jsp");
            return new ModelAndView(jspView).addModel("user", user);
        }
        JspView jspView= new JspView(REDIRECT + "/");

        return new ModelAndView(jspView);
    }
}