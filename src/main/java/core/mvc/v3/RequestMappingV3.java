package core.mvc.v3;

import jwp.controller.v1.*;
import jwp.controller.v1.login.*;
import jwp.controller.v1.qna.*;
import jwp.controller.v1.user.*;
import jwp.controller.v2.*;
import jwp.controller.v2.login.*;
import jwp.controller.v2.qna.*;
import jwp.controller.v2.user.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RequestMappingV3 {
    private final Map<String, Object> handlers = new HashMap<>();

    public RequestMappingV3() {
        initHandlers();
    }

    private void initHandlers() {
        // v1
        handlers.put("/v3/v1", new HomeControllerV1());

        handlers.put("/v3/v1/user/form", new ForwardControllerV1("/v3/v1/user/form"));
        handlers.put("/v3/v1/user/loginForm", new ForwardControllerV1("/v3/v1/user/login"));
        handlers.put("/v3/v1/user/loginFailed", new ForwardControllerV1("/v3/v1/user/login_failed"));


        handlers.put("/v3/v1/user/userList", new ListUserControllerV1());
        handlers.put("/v3/v1/user/login", new LogInControllerV1());
        handlers.put("/v3/v1/user/logout", new LogOutControllerV1());
        handlers.put("/v3/v1/user/signup", new CreateUserControllerV1());
        handlers.put("/v3/v1/user/updateForm", new UpdateUserFormControllerV1());
        handlers.put("/v3/v1/user/update", new UpdateUserControllerV1());

        handlers.put("/v3/v1/qna/form", new ForwardControllerV1("/v3/v1/qna/form"));
        handlers.put("/v3/v1/qna/show", new ShowQuestionControllerV1());
        handlers.put("/v3/v1/api/qna/addAnswer", new AddAnswerControllerV1());

        // v2
        handlers.put("/v3/v2", new HomeControllerV2());

        handlers.put("/v3/v2/user/form", new ForwardControllerV2("/v3/v2/user/form"));
        handlers.put("/v3/v2/user/loginForm", new ForwardControllerV2("/v3/v2/user/login"));
        handlers.put("/v3/v2/user/loginFailed", new ForwardControllerV2("/v3/v2/user/login_failed"));


        handlers.put("/v3/v2/user/userList", new ListUserControllerV2());
        handlers.put("/v3/v2/user/login", new LogInControllerV2());
        handlers.put("/v3/v2/user/logout", new LogOutControllerV2());
        handlers.put("/v3/v2/user/signup", new CreateUserControllerV2());
        handlers.put("/v3/v2/user/updateForm", new UpdateUserFormControllerV2());
        handlers.put("/v3/v2/user/update", new UpdateUserControllerV2());

        handlers.put("/v3/v2/qna/form", new ForwardControllerV2("/v3/v2/qna/form"));
        handlers.put("/v3/v2/qna/show", new ShowQuestionControllerV2());
        handlers.put("/v3/v2/api/qna/addAnswer", new AddAnswerControllerV2());
    }

    public Object getHandler(HttpServletRequest request) {
        return handlers.get(request.getRequestURI());
    }
}
