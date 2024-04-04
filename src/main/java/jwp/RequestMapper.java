package jwp;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import jwp.controller.Controller;
import jwp.controller.CreateUserController;
import jwp.controller.ForwardController;
import jwp.controller.HomeController;
import jwp.controller.ListUserController;
import jwp.controller.LoginController;
import jwp.controller.LogoutController;
import jwp.controller.UpdateUserFormController;

public class RequestMapper {
    private final Map<String, Controller> controllers = new HashMap<>();

    public RequestMapper() {
        init();
    }

    public void init() {
        controllers.put("forward", new ForwardController());
        controllers.put("/user/signup", new CreateUserController());
        controllers.put("", new HomeController());
        controllers.put("/user/userList", new ListUserController());
        controllers.put("/user/login", new LoginController());
        controllers.put("/user/logout", new LogoutController());
        controllers.put("/user/update", new UpdateUserFormController());
    }

    public Controller mapRequest(String path) {
        if(path.endsWith(".jsp")) {
            return controllers.get("forward");
        }
        return controllers.get(path);
    }
}
