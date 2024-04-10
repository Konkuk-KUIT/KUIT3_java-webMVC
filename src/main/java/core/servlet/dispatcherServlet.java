package core.servlet;

import core.mvc.RequestMapping;
import core.mvc.view.ModelAndView;
import jwp.controller.Controller;
import jwp.controller.ForwardController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class dispatcherServlet extends HttpServlet {
    private controllerMapper mapper;
    static int counter = 0;
    /*@Override
    public void init(){
        this.mapper = new controllerMapper();
    }*/
    @Override
    public void init() throws ServletException {
        this.mapper = new controllerMapper();
    }
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*counter++;
        if(counter>100){
            return;
        }*/
        Controller controller = mapper.mapController(req.getRequestURI());
        ModelAndView commend;
        if(controller!= null){
            commend = controller.execute(req,resp);
        }else{
            System.out.println("mapper cannot found Controller : "+req.getRequestURI());
            return;
        }
        if(commend==null){
            return;
        }
        move(commend,req,resp);

        /*
        if(commend.startsWith("redirect:")){
            String redirectURL = commend.substring(9);
            System.out.println("redirect URL : "+ redirectURL);
            resp.sendRedirect(redirectURL);
            return;
        }*/
    }

    private void move(ModelAndView modelAndView, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        modelAndView.render(req,resp);
    }

}
