package core.mvc.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class JspView implements View{

    private String viewName;
    private boolean isRedirect;

    public JspView(String viewName, boolean isRedirect) {
        this.viewName = viewName;
        this.isRedirect = isRedirect;
    }

    @Override
    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (isRedirect) {
            response.sendRedirect(viewName);
            return;
        }

        Set<String> keys = model.keySet();
        for (String key: keys) {
            request.setAttribute(key,model.get(key));
        }

        setModelToRequestAttribute(model, request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewName);
        requestDispatcher.forward(request, response);
    }

    private void setModelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        model.forEach(request::setAttribute);
    }
}