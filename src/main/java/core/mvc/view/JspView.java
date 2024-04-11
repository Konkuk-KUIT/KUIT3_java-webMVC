package core.mvc.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import static core.mvc.Controller.REDIRECT;

public class JspView implements View{

    private final String viewName;
    private static final String REDIRECT = "redirect:";


    public JspView(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // model에 있는 정보 넘겨주기
        for(String key : model.keySet()) {
            request.setAttribute(key, model.get(key));
        }

        if (viewName.startsWith(REDIRECT)) {
            response.sendRedirect(viewName.substring(REDIRECT.length()));
            return;
        }

        RequestDispatcher rd = request.getRequestDispatcher(viewName);
        rd.forward(request, response);
    }
}