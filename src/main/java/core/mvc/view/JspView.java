package core.mvc.view;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JspView implements View{
    private final String path;

    public JspView(String path) {
        this.path = path;
    }

    @Override
    public void render(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (path.startsWith("redirect:")) {
            resp.sendRedirect(path.substring("redirect:".length()));
            return;
        }

        RequestDispatcher rd = req.getRequestDispatcher(path);
        rd.forward(req, resp);
    }


}
