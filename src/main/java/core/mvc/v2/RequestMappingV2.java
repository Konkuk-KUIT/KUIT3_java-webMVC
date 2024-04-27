package core.mvc.v2;

import jwp.controller.v2.*;
import jwp.controller.v2.login.*;
import jwp.controller.v2.qna.*;
import jwp.controller.v2.user.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RequestMappingV2 {
    private Map<String , ControllerV2> controllers = new HashMap<>();

    public RequestMappingV2() {
        initControllers();
    }

    private void initControllers() {
        controllers.put("/v2", new HomeControllerV2());

        controllers.put("/v2/user/form", new ForwardControllerV2("/v2/user/form"));
        controllers.put("/v2/user/loginForm", new ForwardControllerV2("/v2/user/login"));
        controllers.put("/v2/user/loginFailed", new ForwardControllerV2("/v2/user/login_failed"));


        controllers.put("/v2/user/userList", new ListUserControllerV2());
        controllers.put("/v2/user/login", new LogInControllerV2());
        controllers.put("/v2/user/logout", new LogOutControllerV2());
        controllers.put("/v2/user/signup", new CreateUserControllerV2());
        controllers.put("/v2/user/updateForm", new UpdateUserFormControllerV2());
        controllers.put("/v2/user/update", new UpdateUserControllerV2());

        controllers.put("/v2/qna/form", new ForwardControllerV2("/v2/qna/form"));
        controllers.put("/v2/qna/show", new ShowQuestionControllerV2());
        controllers.put("/v2/api/qna/addAnswer", new AddAnswerControllerV2());
    }

    public ControllerV2 getController(HttpServletRequest request) {
        return controllers.get(request.getRequestURI());
    }
}
