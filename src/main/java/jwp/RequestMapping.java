package jwp;

import jwp.controller.*;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
    private Map<String, Controller> controllers = new HashMap<>() {{
        put("/user/userList", new ListUserController());
        put("/user/signup", new CreateUserController());
        put("/", new HomeController());
        put("/user/login", new LoginController());
        put("/user/logout", new LogoutController());
        put("/user/update", new UpdateListController());
        put("/user/updateForm", new UserUpdateController());
    }};

    public RequestMapping() {
    }

    public Controller get(String req){
        return controllers.get(req);
    }
}
