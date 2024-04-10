package jwp.mvc;

import jwp.constants.HttpMethod;
import jwp.constants.JspPath;
import jwp.constants.URL;
import jwp.controller.*;
import jwp.controller.qna.ShowQuestionController;
import jwp.controller.qna.api.AddAnswerController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestMapper {

    Map<String, Controller> controllers = new HashMap<>();

    public RequestMapper() {
        init();
    }

    private void init() {
        controllers.put(toKey(HttpMethod.GET, URL.HOME), new HomeController());

        controllers.put(toKey(HttpMethod.GET, URL.USER_LOGIN), new ForwardController(JspPath.USER_LOGIN));
        controllers.put(toKey(HttpMethod.POST, URL.USER_LOGIN), new LoginController());
        controllers.put(toKey(HttpMethod.GET, URL.USER_LOGOUT), new LogoutController());

        controllers.put(toKey(HttpMethod.GET, URL.USER_SIGNUP), new ForwardController(JspPath.USER_FORM));
        controllers.put(toKey(HttpMethod.POST, URL.USER_SIGNUP), new CreateUserController());

        controllers.put(toKey(HttpMethod.GET, URL.USER_UPDATE_FORM), new UpdateUserFormController());
        controllers.put(toKey(HttpMethod.POST, URL.USER_UPDATE_FORM), new ModifyUserController());

        controllers.put(toKey(HttpMethod.GET, URL.USER_LIST), new ListUserController());

        controllers.put(toKey(HttpMethod.GET, URL.QNA_FORM), new ForwardController(JspPath.QNA_FORM));
        controllers.put(toKey(HttpMethod.POST, URL.QNA_FORM), new ForwardController(JspPath.QNA_FORM));
        controllers.put(toKey(HttpMethod.GET, URL.QNA_SHOW), new ShowQuestionController());

        controllers.put(toKey(HttpMethod.POST, URL.API_ADD_ANSWER), new AddAnswerController());
    }

    public Controller getController(HttpServletRequest req) {
        Logger.getLogger("mapper").log(Level.INFO, req.getRequestURI());
        return controllers.get(toKey(req.getMethod(), req.getRequestURI()));
    }

    private String toKey(String method, String url) {
        return method + "#" + url;
    }

    private String toKey(HttpMethod method, URL url) {
        return method.getString() + "#" + url.get();
    }

}
