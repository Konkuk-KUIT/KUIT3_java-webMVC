package core.mvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
    private RequestMapper requestMapper;

    @Override
    public void init() throws ServletException {
        requestMapper = new RequestMapper();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Controller controller = requestMapper.getController(req);

        // 비즈니스 로직 처리
        String viewName = controller.execute(req, resp);

        // redirect or forward
        move(viewName, req, resp);
    }

    private void move(String viewName, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // redirect
        if (viewName.startsWith("redirect:")) {
            int index = viewName.indexOf(":");
            String url = viewName.substring(index + 1);
            resp.sendRedirect(url);
            return;
        }
        // forward
        RequestDispatcher rd = req.getRequestDispatcher(viewName);
        rd.forward(req, resp);
    }
}
