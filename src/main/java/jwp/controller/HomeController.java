package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements Controller {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/home.jsp";
    }
}
