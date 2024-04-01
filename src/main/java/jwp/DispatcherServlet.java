package jwp;

import jwp.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispathcer", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
    private RequestMapping rq;


    @Override
    public void init() throws ServletException {
        this.rq = new RequestMapping();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Controller controller = rq.get(req.getRequestURI());
        try {
            String viewName = controller.execute(req, resp);
            if(viewName.startsWith("redirect:")){
                resp.sendRedirect(viewName.split("redirect:")[1]);
                return;
            }
            RequestDispatcher rd = req.getRequestDispatcher(viewName);
            rd.forward(req, resp);
        } catch (Throwable e) {
            throw new ServletException(e.getMessage());
        }
    }


}
