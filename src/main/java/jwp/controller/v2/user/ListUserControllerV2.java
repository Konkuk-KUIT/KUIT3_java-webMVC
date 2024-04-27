package jwp.controller.v2.user;

import core.db.MemoryUserRepository;
import core.mvc.v2.ControllerV2;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class ListUserControllerV2 implements ControllerV2 {
    private final MemoryUserRepository memoryUserRepository = MemoryUserRepository.getInstance();
    private boolean isLoggedIn = false;

    @Override
    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    @Override
    public String execute(Map<String, String> params, Map<String, Object> model) throws IOException {
        log.info("ListUserControllerV2");

        if (isLoggedIn) {
            model.put("users", memoryUserRepository.findAll());
            return "/v2/user/list";
        }
        return REDIRECT+"/v2/user/loginForm";
    }
}
