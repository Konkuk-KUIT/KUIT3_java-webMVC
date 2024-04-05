package core.servlet;

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
    controllerMapper mapper=new controllerMapper();;
    static int counter = 0;
    /*@Override
    public void init(){
        this.mapper = new controllerMapper();
    }*/

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);//?
        counter++;
        if(counter>100){
            return;
        }
        Controller controller = mapper.mapController(req.getRequestURI());
        String commend;
        if(controller!= null){
            commend = controller.execute(req,resp);
        }else{
            System.out.println("mapper cannot found Controller");
            return;
        }
        if(commend==null){
            return;
        }
        if(commend.startsWith("redirect:")){
            String redirectURL = commend.substring(9);
            System.out.println("redirect URL : "+ redirectURL);
            resp.sendRedirect(redirectURL);
            return;
        }

        try {
            RequestDispatcher rd = req.getRequestDispatcher(commend);
            System.out.println("forward Path : " + commend);
            rd.forward(req, resp);
        }catch (Throwable e) {
            throw new ServletException(e.getMessage());
        }
    }

}
