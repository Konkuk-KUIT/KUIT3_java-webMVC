package jwp.server;

import jwp.constants.HttpMethod;
import jwp.constants.JspPath;
import jwp.constants.URL;
import jwp.controller.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RequestMapper {

    Map<String, Controller> controllers = new HashMap<>();

    public RequestMapper() {
        init();
    }

    private void init() {
        controllers.put(toKey(HttpMethod.GET, URL.HOME), new ForwardController(JspPath.HOME));

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
        controllers.put(toKey(HttpMethod.GET, URL.QNA_SHOW), new ForwardController(JspPath.QNA_SHOW));
    }

    public Controller getController(HttpServletRequest req) {
        return controllers.get(toKey(req.getMethod(), req.getRequestURI()));
    }

    private String toKey(String method, String url) {
        return method + "#" + url;
    }

    private String toKey(HttpMethod method, URL url) {
        return method.getString() + "#" + url.get();
    }

}
