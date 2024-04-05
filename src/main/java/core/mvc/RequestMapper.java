package core.mvc;

import jwp.controller.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestMapper {
    private Map<String, Controller> controllers = new HashMap<>();

    public RequestMapper() {
        initControllers();
    }

    private void initControllers() {
        controllers.put("/user/signupForm", new ForwardController("/user/form.jsp"));
        controllers.put("/user/loginForm", new ForwardController("/user/login.jsp"));
        controllers.put("/user/loginFailed", new ForwardController("/user/login_failed.jsp"));
        controllers.put("/qna/form", new ForwardController("/qna/form.jsp"));
        controllers.put("/qna/show", new ForwardController("/qna/show.jsp"));

        controllers.put("/", new HomeController());
        controllers.put("/user/signup", new CreateUserController());
        controllers.put("/user/userList", new ListUserController());
        controllers.put("/user/updateForm", new UpdateUserFormController());
        controllers.put("/user/update", new UpdateUserController());
        controllers.put("/user/login", new LoginController());
        controllers.put("/user/logout", new LogoutController());
    }

    public Controller getController(HttpServletRequest req) {
        return controllers.get(req.getRequestURI());
    }
}
