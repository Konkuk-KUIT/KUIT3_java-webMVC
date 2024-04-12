package jwp.mvc;

import jwp.controller.Controller;
import jwp.mvc.RequestMapper;
import jwp.mvc.view.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    RequestMapper mapper;

    @Override
    public void init() {
        mapper = new RequestMapper();
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Controller controller = mapper.getController(req);
        ModelAndView result = controller.execute(req, resp);
        if(result == null) return;
        result.render(req, resp);
    }

}
