package jwp.controller;

import java.util.HashMap;
import java.util.Map;

public class RequestMapper {

    private static final Map<String,Controller> map=new HashMap<>();

    static{
        map.put("/",new HomeController());
        map.put("/user/signup",new CreateUserController());
        map.put("/user/userList",new ListUserController());
        map.put("/user/login",new loginController());
        map.put("/user/logout",new logoutController());
        map.put("/user/update",new UpdateUserController());
        map.put("/user/updateForm",new UpdateUserFormController());
    }
    private RequestMapper(){
    }
    public static Map<String,Controller> getInstance(){
        return map;
    }
}
