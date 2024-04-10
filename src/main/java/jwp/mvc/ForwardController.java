package jwp.mvc;

import jwp.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardController implements Controller {
    String url;
    public String execute(HttpServletRequest request, HttpServletResponse response0) throws Exception {
        return url;
    }


    ForwardController(String url){
        this.url = url;
    }


}
