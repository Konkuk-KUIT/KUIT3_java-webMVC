package jwp.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/")
public class FrontController extends HttpServlet {

    private final Map<String, Controller> controllerMap = new HashMap<>();

    public FrontController(){
        controllerMap.put("/", new HomeController());
        controllerMap.put("/user/update", new UpdateUserController());
        controllerMap.put("/user/updateForm", new UpdateUserFormController());
        controllerMap.put("/user/logout", new LogOutController());
        controllerMap.put("/user/login", new LogInController());
        controllerMap.put("/user/userList", new ListUserController());
        controllerMap.put("/user/signup", new CreateUserController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        Controller controller = controllerMap.get(requestURI);
        if (controller == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        controller.process(req, resp);
    }
}


