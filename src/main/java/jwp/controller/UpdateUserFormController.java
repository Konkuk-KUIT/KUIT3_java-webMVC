package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import core.mvc.view.JSPView;
import core.mvc.view.ModelAndView;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserFormController extends AbstractController {
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if (user != null) {
            ModelAndView model = JSPView("/user/updateForm.jsp");
            model.addModel("user", user);
            //req.setAttribute("user", user);
            return model;
        }
        return JSPView(REDIRECT + "/");
    }
}