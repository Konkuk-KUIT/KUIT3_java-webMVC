package core.mvcFramework;

import jwp.controller.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RequestMapper {
    private Map<String,Controller> controlMap = new HashMap<>();

    public RequestMapper(){
        initControllers();
    }

    private void initControllers(){
        controlMap.put("/",new HomeController());

        controlMap.put("/user/form", new ForwardController("/user/form.jsp"));
        controlMap.put("/user/loginForm", new ForwardController("/user/login.jsp"));
        controlMap.put("/user/loginFailed", new ForwardController("/user/login_failed.jsp"));
        controlMap.put("/qna/form", new ForwardController("/qna/form.jsp"));
        controlMap.put("/qna/show", new ForwardController("/qna/show.jsp"));


        controlMap.put("/user/userList", new ListUserController());

        controlMap.put("/user/login", new LoginController());
        controlMap.put("/user/logout", new LogoutController());

        controlMap.put("/user/signup", new CreateUserController());

        controlMap.put("/user/updateForm", new UpdateUserFormController());
        controlMap.put("/user/update", new UpdateUserController());
    }

    public Controller getController(HttpServletRequest request) {
        return controlMap.get(request.getRequestURI());
    }
}
