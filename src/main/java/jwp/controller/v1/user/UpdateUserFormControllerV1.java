package jwp.controller.v1.user;

import core.db.MemoryUserRepository;
import core.mvc.v1.ControllerV1;
import core.mvc.view.ModelAndView;
import jwp.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class UpdateUserFormControllerV1 implements ControllerV1 {
    @Override
    public ModelAndView execute(Map<String, String> params) {
        log.info("UpdateUserFormControllerV1");
        String userId = params.get("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if (user != null) {
            ModelAndView modelAndView = new ModelAndView("/v1/user/updateForm");
            modelAndView.getModel().put("user", user);
            return modelAndView;
        }
        return new ModelAndView(REDIRECT + "/v1");
    }
}