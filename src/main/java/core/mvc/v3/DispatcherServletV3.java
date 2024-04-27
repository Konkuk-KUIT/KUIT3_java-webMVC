package core.mvc.v3;

import core.mvc.v3.adapter.ControllerV1HandlerAdapter;
import core.mvc.v3.adapter.ControllerV2HandlerAdapter;
import core.mvc.v3.adapter.HandlerAdapter;
import core.mvc.view.JsonView;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@WebServlet(name = "dispatcherV3", urlPatterns = "/v3/*", loadOnStartup = 1)
public class DispatcherServletV3 extends HttpServlet {

    private RequestMappingV3 requestMapping;
    private final List<HandlerAdapter> handlerAdapters = new ArrayList<>();

    private static final String REDIRECT_PREFIX = "redirect:";
    private static final String JSON_VIEW_PREFIX = "jsonView";

    @Override
    public void init(){
        this.requestMapping = new RequestMappingV3();
        initHandlerAdapters();
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV1HandlerAdapter());
        handlerAdapters.add(new ControllerV2HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("=== DispatcherServlet V3 ===");
        Object handler = requestMapping.getHandler(req);
        if (handler == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        HandlerAdapter adapter = getHandlerAdapter(handler);
        ModelAndView modelAndView;
        try {
            modelAndView = adapter.handle(req, resp, handler);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        String viewName = modelAndView.getViewName();
        if (viewName == null) return;
        View view = getView(viewName);
        view.render(modelAndView.getModel(), req, resp);
    }

    private HandlerAdapter getHandlerAdapter(Object handler) {
        for (HandlerAdapter adapter : handlerAdapters) {
            if (adapter.supports(handler)) {
                return adapter;
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler=" + handler);
    }

    private View getView(String viewName) {
        if (viewName.equals(JSON_VIEW_PREFIX)) {
            return new JsonView();
        }
        boolean isRedirect = viewName.startsWith(REDIRECT_PREFIX);
        return jspViewResolver(viewName, isRedirect);
    }


    private JspView jspViewResolver(String viewName, boolean isRedirect) {
        if (isRedirect) {
            return new JspView(viewName.substring(REDIRECT_PREFIX.length()), true);
        }
        return new JspView("/WEB-INF/" + viewName + ".jsp", false);
    }
}