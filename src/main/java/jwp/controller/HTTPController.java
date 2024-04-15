package jwp.controller;


import core.mvc.view.JsonView;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import jwp.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class HTTPController implements Controller {
    private static final Logger log = Logger.getLogger(HTTPController.class.getName());
    static final String REDIRECT = "redirect:";
    ModelAndView modelAndView;
    /*private request req;
    private response res;*/

    @Override
    public ModelAndView execute(HttpServletRequest req ){
        try {
            if (req.getMethod().equals("GET")) {
                return doGet(req);
            }
            if (req.getMethod().equals("POST")) {
                return doPost(req);
            }
            log.log(Level.SEVERE, "invalid Method");
            return null;
        }catch(Exception e) {
            return null;
        }
    }

    protected ModelAndView doPost(HttpServletRequest req) throws ServletException, IOException{return null;};
    protected ModelAndView doGet(HttpServletRequest req)throws ServletException, IOException{return null;};

    protected ModelAndView jspView(String filePath){return new ModelAndView(new JspView(filePath));}
    protected ModelAndView jsonView(){return new ModelAndView(new JsonView());}
}