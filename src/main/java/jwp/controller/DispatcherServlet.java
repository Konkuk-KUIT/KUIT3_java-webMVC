package jwp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jwp.RequestMapper;

@WebServlet(name="dispathcer", urlPatterns="/", loadOnStartup=1)
public class DispatcherServlet extends HttpServlet {
//    Map<String, Controller> controllers = new HashMap<>();
    RequestMapper requestMapper = new RequestMapper();

    @Override
    public void init() throws ServletException {
//        controllers.put("forward", new ForwardController());
//        controllers.put("/user/signup", new CreateUserController());
//        controllers.put("", new HomeController());
//        controllers.put("/user/userList", new ListUserController());
//        controllers.put("/user/login", new LoginController());
//        controllers.put("/user/logout", new LogoutController());
//        controllers.put("/user/update", new UpdateUserFormController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        Controller controller = requestMapper.mapRequest(requestURI);
        String dd = controller.execute(req, resp);  // should return string
        if(dd.startsWith("redirect:")) {
            resp.sendRedirect(dd.split("redirect:")[1]);
        }
        else {
            RequestDispatcher rd = req.getRequestDispatcher(dd);
            rd.forward(req, resp);

        }
    }

    //    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("DISPATCHER SERVLET CAUGHT");
//        String requestURI = req.getRequestURI();
//        if(requestURI.endsWith(".jsp")) {
//            controllers.get("forward").execute(req, resp);
//        }
//        controllers.get(requestURI).execute(req, resp);
//    }
}
