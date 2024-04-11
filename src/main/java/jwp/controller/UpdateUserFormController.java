package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import jwp.model.User;

import java.io.IOException;
import java.util.Map;

public class UpdateUserFormController extends AbstractController {
    @Override
    public ModelAndView execute(Map<String, String> paraMap) throws IOException {
        String userId = paraMap.get("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if (user != null) {
            ModelAndView mav = jspView("/user/updateForm.jsp");
            mav.addModel("user", user);
            return mav;
        }
        return jspView(REDIRECT + "/");
    }
}