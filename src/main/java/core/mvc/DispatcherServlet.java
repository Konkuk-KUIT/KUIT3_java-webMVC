package core.mvc;

import core.mvc.view.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

  private RequestMapping requestMapping;

  @Override
  public void init() throws ServletException {
    this.requestMapping = new RequestMapping();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Controller controller = requestMapping.getController(req);
    controller.setSession(req.getSession(true));
    try {
      ModelAndView mav = controller.execute(createParams(req));
      mav.render(req, resp);
    } catch (Throwable e) {
      throw new ServletException(e.getMessage());
    }
  }

  private Map<String, String> createParams(HttpServletRequest request) {
    Map<String, String> params = new HashMap<>();
    request.getParameterNames().asIterator().forEachRemaining(
      paramName -> params.put(paramName, request.getParameter(paramName)));
    return params;
  }
}