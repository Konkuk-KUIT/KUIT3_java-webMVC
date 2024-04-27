package jwp.controller.v2.login;

import core.mvc.v2.ControllerV2;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class LogOutControllerV2 implements ControllerV2 {
    HttpSession session;
    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Override
    public String execute(Map<String, String> params, Map<String, Object> model) throws IOException {
        log.info("LogOutControllerV2");
        session.removeAttribute("user");
        return REDIRECT + "/v2";
    }
}