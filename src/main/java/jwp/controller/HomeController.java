package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController extends HttpController {
    @Override
    protected String doGet(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("HOME CONTROLLER CALLED");
        return "/index.jsp";
    }
}
