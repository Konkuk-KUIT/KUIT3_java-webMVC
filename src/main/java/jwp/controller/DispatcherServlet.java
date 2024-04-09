package jwp.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jwp.RequestMapper;

@WebServlet(name="dispathcer", urlPatterns="/", loadOnStartup=1)
public class DispatcherServlet extends HttpServlet {
    private final RequestMapper requestMapper = new RequestMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        Controller controller = requestMapper.mapRequest(requestURI);
        String retString = controller.execute(req, resp);  // should return string
        if(retString.startsWith("redirect:")) {
            resp.sendRedirect(retString.split("redirect:")[1]);
        }
        else {
            RequestDispatcher rd = req.getRequestDispatcher(retString);
            rd.forward(req, resp);
        }
    }
}
