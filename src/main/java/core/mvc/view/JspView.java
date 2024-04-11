package core.mvc.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JspView implements View {
    private final String viewName;
    private static final String REDIRECT_PREFIX = "redirect:";

    public JspView(String viewName) {
        this.viewName = viewName;
    }

    // dispatcherServlet에서 경로에 따라 move했었던 것을 JspView로 가져옴 => 반환 데이터의 타입 다양하기 때문
    @Override
    public void render(HashMap<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (viewName.startsWith(REDIRECT_PREFIX)) {
            response.sendRedirect(viewName.substring(REDIRECT_PREFIX.length()));
            return;
        }

        //request에 model 저장
        for (String key : model.keySet()) {
            request.setAttribute(key, model.get(key));
        }

        RequestDispatcher rd = request.getRequestDispatcher(viewName);
        rd.forward(request, response);
    }
}
