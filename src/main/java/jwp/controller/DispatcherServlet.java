package jwp.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "dispatcher", urlPatterns = "/",loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Controller controller=mappingController(req.getRequestURI());
        try {
            String result=controller.process(req,resp);
            forward(req,resp,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void forward(HttpServletRequest req, HttpServletResponse resp, String command) throws ServletException, IOException {
        if(!isRedirect(command)){
            RequestDispatcher rd = req.getRequestDispatcher(command);
            rd.forward(req, resp);
            return;
        }


        String redirectUrl = command.substring(9);
        String baseUrl = "http://localhost:8080";
        resp.sendRedirect(baseUrl+redirectUrl);

    }

    private Controller mappingController(String controllerName){
        return RequestMapper.getInstance().get(controllerName);
    }

    private boolean isRedirect(String command){
        return command.startsWith("redirect:");
    }
}
