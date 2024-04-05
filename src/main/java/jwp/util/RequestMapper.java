package jwp.util;

import jwp.controller.*;

import java.util.HashMap;
import java.util.Map;

public class RequestMapper {
    private Map<String, Controller> mapper;

    public RequestMapper() {
        this.mapper = new HashMap<>();
        initMapper();
    }

    private void initMapper(){
        mapper.put("/", new HomeController());
        mapper.put("/user/signup", new CreateUserController());
        mapper.put("/user/userList", new ListUserController());
        mapper.put("/user/login", new LoginController());
        mapper.put("/user/logout", new LogoutController());
        mapper.put("/user/update", new UserUpdateController());
        mapper.put("/user/updateForm", new UserUpdateFormController());
        mapper.put("/user/loginForm", new ForwardController("/user/login.jsp"));
        mapper.put("/user/signupForm", new ForwardController("/user/form.jsp"));
    }

    public Controller requestMapping(String uri){
        Controller result = mapper.get(uri);
        if(result == null){
            return mapper.get("any");
        }
        return result;
    }

//    public Controller requestMapping(String uri){
//        if(mapper.containsKey(uri)){
//            return mapper.get(uri);
//        }
//        return mapper.get("any");
//
//    }
}
