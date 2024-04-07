package core.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class JspView implements View{
    private String path;

    public JspView(String path) {
        this.path = path;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        for (Map.Entry<String, ?> entry : model.entrySet()) {
            request.setAttribute(entry.getKey(), entry.getValue());
        }
        request.getRequestDispatcher(path).forward(request, response);
    }
}
