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
        String result = controller.execute(req, resp);

        // redirect
        if (result.startsWith("redirect:")) {
            int index = result.indexOf(":");
            String url = result.substring(index + 1);
            resp.sendRedirect(url);
            return;
        }
        // forward
        RequestDispatcher rd = req.getRequestDispatcher(result);
        rd.forward(req, resp);
    }
}
