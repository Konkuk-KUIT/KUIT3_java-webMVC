package jwp.controller.v3.login;

import core.db.MemoryUserRepository;
import core.mvc.v1.ControllerV1;
import core.mvc.view.ModelAndView;
import jwp.model.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Slf4j
public class LogInControllerV1 implements ControllerV1 {
    private final MemoryUserRepository memoryUserRepository = MemoryUserRepository.getInstance();

    HttpSession session;
    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }


    @Override
    public ModelAndView execute(Map<String, String> params) {
        log.info("LogInControllerV1");

        String userId = params.get("userId");
        String password = params.get("password");
        User user = memoryUserRepository.findUserById(userId);

        if (user != null && user.isSameUser(userId, password)) {
            session.setAttribute("user", user);
            return new ModelAndView(REDIRECT + "/v1");
        }
        return new ModelAndView(REDIRECT + "/v1/user/loginFailed");
    }
}