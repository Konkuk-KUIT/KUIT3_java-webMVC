package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("FORWARD CONTROLLER CALLED");
        return req.getRequestURI();
    }
}
