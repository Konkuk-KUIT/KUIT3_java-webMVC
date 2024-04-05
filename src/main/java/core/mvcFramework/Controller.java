package core.mvcFramework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    static final String REDIRCT = "redirect:";
    String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
