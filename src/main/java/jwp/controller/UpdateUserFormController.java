package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import jwp.model.User;

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