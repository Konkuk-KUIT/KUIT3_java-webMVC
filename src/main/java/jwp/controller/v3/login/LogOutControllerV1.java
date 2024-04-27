package jwp.controller.v3.login;

import core.mvc.v1.ControllerV1;
import core.mvc.view.ModelAndView;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Slf4j
public class LogOutControllerV1 implements ControllerV1 {
    HttpSession session;
    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Override
    public ModelAndView execute(Map<String, String> params) {
        log.info("LogOutControllerV1");
        session.removeAttribute("user");
        return new ModelAndView(REDIRECT + "/v1");
    }
}