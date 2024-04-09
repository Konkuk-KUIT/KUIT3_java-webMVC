package jwp.controller.front;

import jwp.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

  private final ControllerMapper controllerMapper;
  private static final String REDIRECT_PREFIX = "redirect:";

  public DispatcherServlet() {
    this.controllerMapper = new ControllerMapper();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Controller controller = controllerMapper.getController(req.getRequestURI());
    try {
      String path = controller.execute(req, resp);
      flush(req, resp, path);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void flush(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
    if (path.startsWith(REDIRECT_PREFIX)) {
      resp.sendRedirect(path.substring(REDIRECT_PREFIX.length()));
      return;
    }

    RequestDispatcher rd = req.getRequestDispatcher(path);
    rd.forward(req, resp);
  }
}
