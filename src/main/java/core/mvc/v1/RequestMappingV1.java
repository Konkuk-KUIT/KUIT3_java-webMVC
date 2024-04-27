package core.mvc.v1;

import jwp.controller.v1.*;
import jwp.controller.v1.login.*;
import jwp.controller.v1.user.*;
import jwp.controller.v1.qna.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RequestMappingV1 {
    private Map<String , ControllerV1> controllers = new HashMap<>();

    public RequestMappingV1() {
        initControllers();
    }

    private void initControllers() {
        controllers.put("/v1", new HomeControllerV1());

        controllers.put("/v1/user/form", new ForwardControllerV1("/v1/user/form"));
        controllers.put("/v1/user/loginForm", new ForwardControllerV1("/v1/user/login"));
        controllers.put("/v1/user/loginFailed", new ForwardControllerV1("/v1/user/login_failed"));


        controllers.put("/v1/user/userList", new ListUserControllerV1());
        controllers.put("/v1/user/login", new LogInControllerV1());
        controllers.put("/v1/user/logout", new LogOutControllerV1());
        controllers.put("/v1/user/signup", new CreateUserControllerV1());
        controllers.put("/v1/user/updateForm", new UpdateUserFormControllerV1());
        controllers.put("/v1/user/update", new UpdateUserControllerV1());

        controllers.put("/v1/qna/form", new ForwardControllerV1("/v1/qna/form"));
        controllers.put("/v1/qna/show", new ShowQuestionControllerV1());
        controllers.put("/v1/api/qna/addAnswer", new AddAnswerControllerV1());
    }

    public ControllerV1 getController(HttpServletRequest request) {
        return controllers.get(request.getRequestURI());
    }
}
