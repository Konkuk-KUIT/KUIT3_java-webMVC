package jwp.controller;

import jwp.util.RequestMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();

        log("requestURI = " + requestURI );

        RequestMapper mapper = new RequestMapper();

        Controller controller = mapper.requestMapping(requestURI);
        String result = "";

        log("controller = " + controller);

        try {
            result = controller.execute(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        log("result = " + result);


        if(result.startsWith("redirect:")){
            resp.sendRedirect(result.substring(result.indexOf(":") + 1));
            return;
        }
        RequestDispatcher rd = req.getRequestDispatcher(result);
        rd.forward(req, resp);
    }
}
