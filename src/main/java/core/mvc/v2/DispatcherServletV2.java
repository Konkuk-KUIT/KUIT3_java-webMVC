package core.mvc.v2;

import core.mvc.view.JsonView;
import core.mvc.view.JspView;
import core.mvc.view.View;
import jwp.model.User;
import jwp.util.UserSessionUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@WebServlet(name = "dispatcherV2", urlPatterns = "/v2/*", loadOnStartup = 1)
public class DispatcherServletV2 extends HttpServlet {

    private RequestMappingV2 requestMapping;
    private static final String REDIRECT_PREFIX = "redirect:";
    private static final String JSON_VIEW_PREFIX = "jsonView";

    @Override
    public void init() throws ServletException {
        this.requestMapping = new RequestMappingV2();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("=== DispatcherServlet V2 ===");
        ControllerV2 controller = getController(req, resp);
        if (controller == null) return;

        Map<String, Object> model = new HashMap<>();
        String viewName = getViewName(req, controller, model);
        if (viewName == null) return;

        View view = getView(viewName);
        view.render(model, req, resp);
    }

    private String getViewName(HttpServletRequest request, ControllerV2 controller, Map<String, Object> model) {
        Map<String, String> params = createParams(request);
        String viewName;
        try {
            viewName = controller.execute(params, model);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return viewName;
    }

    private Map<String, String> createParams(HttpServletRequest request){
        Map<String, String> params = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> params.put(paramName, request.getParameter(paramName)));
        return params;
    }

    private ControllerV2 getController(HttpServletRequest req, HttpServletResponse resp) {
        ControllerV2 controller = requestMapping.getController(req);
        if(controller == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        setControllerFields(req, controller);
        return controller;
    }

    private View getView(String viewName) {
        if (viewName.equals(JSON_VIEW_PREFIX)) {
            return new JsonView();
        }
        boolean isRedirect = viewName.startsWith(REDIRECT_PREFIX);
        return jspViewResolver(viewName, isRedirect);
    }

    private static void setControllerFields(HttpServletRequest request, ControllerV2 controller) {
        HttpSession session = request.getSession();
        controller.setSession(session);

        boolean isLoggedIn = UserSessionUtils.isLoggedIn(session);
        controller.setIsLoggedIn(isLoggedIn);
        log.info("isLoggedIn={}", isLoggedIn);

        if (isLoggedIn) {
            User userFromSession = UserSessionUtils.getUserFromSession(session);
            controller.setUserFromSession(userFromSession);
        }
    }

    private JspView jspViewResolver(String viewName, boolean isRedirect) {
        if (isRedirect) {
            return new JspView(viewName.substring(REDIRECT_PREFIX.length()), true);
        }
        return new JspView("/WEB-INF/" + viewName + ".jsp", false);
    }
}