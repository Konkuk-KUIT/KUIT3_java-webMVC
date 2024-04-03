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

    private Map<String,Controller>map=new HashMap<>();

    public DispatcherServlet() {
        map.put("/",new HomeController());
        map.put("/user/signup",new CreateUserController());
        map.put("/user/userList",new ListUserController());
        map.put("/user/login",new loginController());
        map.put("/user/logout",new logoutController());
        map.put("/user/update",new UpdateUserController());
        map.put("/user/updateForm",new UpdateUserController());

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        Controller controller=mappingController(req.getRequestURI());
        try {
            String result=controller.process(req,resp);
            forward(req,resp,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void forward(HttpServletRequest req, HttpServletResponse resp, String command) throws ServletException, IOException {
        if(command.length()<9){
            RequestDispatcher rd = req.getRequestDispatcher(command);
            rd.forward(req,resp);
        }
        else {
            String redirect = command.substring(0, 9);
            System.out.println("redirect = " + redirect);
            if (redirect.equals("redirect:")) {
                String redirectUrl = command.substring(10);
                resp.sendRedirect(redirectUrl);
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(command);
                rd.forward(req, resp);
            }
        }

    }

    private Controller mappingController(String controllerName){
        return map.get(controllerName);

    }
}
