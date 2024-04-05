package jwp.controller;

import jwp.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ForwardController implements Controller {

    private String forwardPath=null;

    public ForwardController(String forwardURI){
        this.forwardPath = forwardURI;
    }
    public String execute(HttpServletRequest req, HttpServletResponse resp){
        /*String re = req.getRequestURI();
        if(re.endsWith(".jsp"))
        {//return re;}*/
        System.out.println("forward Controller execute : "+ this.forwardPath+ "(request URI : "+req.getRequestURI()+")");
        return this.forwardPath;
    }
}
