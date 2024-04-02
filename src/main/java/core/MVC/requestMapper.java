package core.MVC;

import jwp.controller.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class requestMapper {
    private Map<String , Controller> controllers = new HashMap<>();

    public requestMapper() {
        initControllers();
    }

    private void initControllers() {
        controllers.put("/", new HomeController());

        controllers.put("/user/form", new ForwardController("/user/form.jsp"));
        controllers.put("/user/loginForm", new ForwardController("/user/login.jsp"));
        controllers.put("/user/loginFailed", new ForwardController("/user/login_failed.jsp"));
        controllers.put("/qna/form", new ForwardController("/qna/form.jsp"));
        controllers.put("/qna/show", new ForwardController("/qna/show.jsp"));


        controllers.put("/user/userList", new ListUserController());

        controllers.put("/user/login", new UserLoginController());
        controllers.put("/user/logout", new UserLogoutController());

        controllers.put("/user/signup", new CreateUserController());

        controllers.put("/user/updateForm", new UpdateUserFormController());
        controllers.put("/user/update", new UserUpdateController());
    }

    public Controller getController(HttpServletRequest request) {
        return controllers.get(request.getRequestURI());
    }
}