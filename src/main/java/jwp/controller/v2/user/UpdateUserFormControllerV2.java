package jwp.controller.v2.user;

import core.db.MemoryUserRepository;
import core.mvc.v2.ControllerV2;
import jwp.model.User;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class UpdateUserFormControllerV2 implements ControllerV2 {
    @Override
    public String execute(Map<String, String> params, Map<String, Object> model) throws IOException {
        log.info("UpdateUserFormControllerV2");
        String userId = params.get("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if (user != null) {
            model.put("user", user);
            return "/v2/user/updateForm";
        }
        return REDIRECT + "/v2";
    }
}