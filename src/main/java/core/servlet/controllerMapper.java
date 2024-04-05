package core.servlet;

import jwp.controller.*;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

public class controllerMapper {
    private static Map<String, Controller> controllers= new HashMap<String, Controller>();
    static {
        controllers.put("/",new HomeController());
        controllers.put("/user/signup",new CreateUserController());
        controllers.put("/user/userList",new ListUserController());
        controllers.put("/user/update",new UpdateUserController());
        controllers.put("/user/updateForm",new UpdateUserFormController());
        controllers.put("/user/login",new UserLoginController());
        controllers.put("/user/logout",new UserLogoutController());
        controllers.put("/user/form",new ForwardController("/user/form.jsp"));
        controllers.put("/user/login_failed",new ForwardController("/user/login_failed.jsp"));
    }

    public Controller mapController(String URL){
        Controller controller = controllers.get(URL);
        /*if(controller==null){return new ForwardController();}*/
        return controller;
    }
}
