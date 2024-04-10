package core.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class View {

    private String viewName;

    private static final String REDIRECT_PREFIX="redirect:";

    public View(String viewName){
        this.viewName=viewName;
    }

    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(viewName.equals("json")){
            renderJson(model,req,resp);
            return;
        }
        renderJsp(model,req,resp);

    }
    public void renderJson(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Jackson 라이브러리 활용
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.print(mapper.writeValueAsString(model.get("json")));

    }
    public void renderJsp(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (viewName.startsWith(REDIRECT_PREFIX)) {
            resp.sendRedirect(viewName.substring(REDIRECT_PREFIX.length()));
            return;
        }
        for (String key : model.keySet()) {
            req.setAttribute(key,model.get(key));
        }
        RequestDispatcher rd = req.getRequestDispatcher(viewName);
        rd.forward(req, resp);
    }
}
