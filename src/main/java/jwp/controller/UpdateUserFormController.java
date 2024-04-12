package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.ModelAndView;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class UpdateUserFormController extends AbstractController {
    MemoryUserRepository userRepository = MemoryUserRepository.getInstance();
    @Override
    public ModelAndView execute(Map<String, String> paramMap) {
        String userId = paramMap.get("userId");
        User user = userRepository.findUserById(userId);
        if (user != null) {
            ModelAndView mav = jspView("/user/updateForm.jsp");
            mav.addModel("user", user);
            return mav;
        }
        return jspView(REDIRECT + "/");
    }
}