package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.model.User;

import java.util.Map;

public class UpdateUserFormController extends AbstractController {
    @Override
    public ModelAndView execute(Map<String, String> params) {
        String userId = params.get("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if (user != null) {
            return jspView("/user/updateForm.jsp").addObject("user", user);
        }
        return jspView(REDIRECT + "/");
    }
}