package core.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public interface Controller {
    ModelAndView execute(Map<String, String> params) throws IOException;

    default void setSession(HttpSession httpSession){};
}