package jwp.mvc;

import jwp.controller.*;

public class RequestMapper {


    public static Controller createController(String url){

        if(url.equals("/user/signup")) return new CreateUserController();
        if(url.equals("/")) return new ForwardController("/");
        if(url.equals("/user/userList")) return new ListUserController();
        if(url.equals("/user/login")) return new LogInController();
        if(url.equals("/user/logout")) return new LogOutController();
        if(url.equals("/user/update")) return new UpdateUserController();
        if(url.equals("/user/updateForm")) return new UpdateUserFormController();
        else return new HomeController();
    }
}
