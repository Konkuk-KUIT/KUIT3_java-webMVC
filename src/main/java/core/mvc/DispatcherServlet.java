package core.mvc;

import jwp.controller.Controller;
import org.apache.tomcat.util.log.UserDataHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    private RequestMapping requestMapping;
    private static final String REDIRECT_PREFIX = "redirect:";
    @Override
    public void init() throws ServletException {
        this.requestMapping = new RequestMapping();
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Controller controller = requestMapping.getController(req);
        try {
            ModelAndView mav = controller.execute(req, resp);
            mav.render(req, resp);
        } catch (Throwable e) {
            throw new ServletException(e.getMessage());
        }
    }
}