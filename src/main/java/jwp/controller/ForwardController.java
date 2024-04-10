package jwp.controller;

import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import jwp.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ForwardController extends HTTPController {

    private String forwardPath=null;

    public ForwardController(String forwardURI){
        if (forwardURI == null) {
            throw new NullPointerException("forwardUrl is null. 이동할 URL을 입력하세요.");
        }
        this.forwardPath = forwardURI;
    }
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp){

        /*String re = req.getRequestURI();
        if(re.endsWith(".jsp"))
        {//return re;}*/
        System.out.println("forward Controller execute : "+ this.forwardPath+ "(request URI : "+req.getRequestURI()+")");

        return new ModelAndView( new JspView(this.forwardPath));
    }

}
