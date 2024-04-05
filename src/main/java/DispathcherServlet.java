import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispathcher", urlPatterns = "/", loadOnStartup = 1)
public class DispathcherServlet extends HttpServlet {
    private RequestMapper requestMapper;

    @Override
    public void init() {
        this.requestMapper = new RequestMapper();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String view = requestMapper.MappingController(req, resp);
            if(view.startsWith("redirect:")){
                resp.sendRedirect(view.substring("redirect:".length()));
                return;
            }
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
