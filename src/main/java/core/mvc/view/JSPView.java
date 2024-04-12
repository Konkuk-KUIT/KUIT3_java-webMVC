package core.mvc.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class JSPView implements View{
    private String viewPath;
    private static final String REDIRECT_PREFIX = "redirect:";

    public JSPView(String viewPath) {
        this.viewPath = viewPath;
    }

    @Override
    public void render(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //request에 model을 저장
        //jsp로 이동
        if (viewPath.startsWith(REDIRECT_PREFIX)) {
            resp.sendRedirect(viewPath.substring(REDIRECT_PREFIX.length()));
            return;
        }
        RequestDispatcher rd = req.getRequestDispatcher(viewPath);
        rd.forward(req, resp);
    }
}
