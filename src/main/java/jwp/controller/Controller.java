package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public interface Controller {
    //
    String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
