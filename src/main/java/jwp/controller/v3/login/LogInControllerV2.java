package jwp.controller.v3.login;

import core.db.MemoryUserRepository;
import core.mvc.v2.ControllerV2;
import jwp.model.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class LogInControllerV2 implements ControllerV2 {
    private final MemoryUserRepository memoryUserRepository = MemoryUserRepository.getInstance();

    HttpSession session;
    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }


    @Override
    public String execute(Map<String, String> params, Map<String, Object> model) throws IOException {
        log.info("LogInControllerV2");

        String userId = params.get("userId");
        String password = params.get("password");
        User user = memoryUserRepository.findUserById(userId);

        if (user != null && user.isSameUser(userId, password)) {
            session.setAttribute("user", user);
            return REDIRECT + "/v2";
        }
        return REDIRECT + "/v2/user/loginFailed";
    }
}