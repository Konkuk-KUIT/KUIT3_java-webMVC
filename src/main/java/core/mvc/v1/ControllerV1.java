package core.mvc.v1;

import core.mvc.view.ModelAndView;
import jwp.model.User;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public interface ControllerV1 {
    static final String REDIRECT = "redirect:";
    ModelAndView execute(Map<String, String> params) throws IOException;
    default void setSession(HttpSession session) {}
    default void setIsLoggedIn(boolean isLoggedIn) {}
    default void setUserFromSession(User user) {}
}