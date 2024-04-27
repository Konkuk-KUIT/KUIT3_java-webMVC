package core.mvc.v2;

import core.mvc.view.ModelAndView;
import jwp.model.User;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public interface ControllerV2 {
    static final String REDIRECT = "redirect:";
    String execute(Map<String, String> params, Map<String, Object> model) throws IOException;
    default void setSession(HttpSession session) {}
    default void setIsLoggedIn(boolean isLoggedIn) {}
    default void setUserFromSession(User user) {}
}