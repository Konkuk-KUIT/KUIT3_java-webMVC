package jwp.controller.v1.user;

import core.db.MemoryUserRepository;
import core.mvc.v1.ControllerV1;
import core.mvc.view.ModelAndView;
import jwp.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class UpdateUserControllerV1 implements ControllerV1 {
    public ModelAndView execute(Map<String, String> params) {
        log.info("UpdateUserControllerV1");
        User user = new User(params.get("userId"),
                params.get("password"),
                params.get("name"),
                params.get("email"));

        MemoryUserRepository.getInstance().changeUserInfo(user);

        return new ModelAndView(REDIRECT + "/v1/user/userList");
    }
}
