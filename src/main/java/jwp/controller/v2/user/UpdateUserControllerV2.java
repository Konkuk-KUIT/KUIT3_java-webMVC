package jwp.controller.v2.user;

import core.db.MemoryUserRepository;
import core.mvc.v2.ControllerV2;
import core.mvc.view.ModelAndView;
import jwp.model.User;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class UpdateUserControllerV2 implements ControllerV2 {
    @Override
    public String execute(Map<String, String> params, Map<String, Object> model) throws IOException {
        log.info("UpdateUserControllerV2");
        User user = new User(params.get("userId"),
                params.get("password"),
                params.get("name"),
                params.get("email"));

        MemoryUserRepository.getInstance().changeUserInfo(user);

        return REDIRECT + "/v2/user/userList";
    }
}
