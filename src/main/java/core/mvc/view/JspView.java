package core.mvc.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class JspView implements View {
  private String viewName;
  static final String REDIRECT = "redirect:";

  private JspView(String viewName) {
    this.viewName = viewName;
  }

  @Override
  public void render(Map<String, Object> models, HttpServletRequest req, HttpServletResponse resp) throws Exception {
    if (viewName.startsWith(REDIRECT)) {
      resp.sendRedirect(viewName.substring(REDIRECT.length()));
      return;
    }

    for (String key : models.keySet()) {
      req.setAttribute(key, models.get(key));
    }
    RequestDispatcher rd = req.getRequestDispatcher(viewName);
    rd.forward(req, resp);
  }

  public static JspView of(String viewName) {
    return new JspView(viewName);
  }
}
