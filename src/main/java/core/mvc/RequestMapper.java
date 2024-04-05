package core.mvc;

import jwp.controller.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RequestMapper {
    private Map<String, Controller> controllers = new HashMap<>();

    public RequestMapper() {
        initController();
    }
    private void initController() {
        controllers.put("/", new HomeController());

        controllers.put("/user/login", new LoginController());
        controllers.put("/user/logout", new LogoutController());

        controllers.put("/user/loginFailed", new ForwardController("/user/loginFailed.jsp"));

        controllers.put("/user/userList", new ListUserController());
        controllers.put("/user/signup", new CreateUserController());

        controllers.put("/user/update", new UpdateUserController());
        controllers.put("/user/updateForm", new UpdateUserFormController());

    }

    public Controller getController(HttpServletRequest req) {
        return controllers.get(req.getRequestURI());
    }
}
