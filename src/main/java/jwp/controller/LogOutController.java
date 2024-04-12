package jwp.controller;

import core.mvc.view.AbstractController;
import core.mvc.view.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class LogOutController extends AbstractController {
  private HttpSession session;

  @Override
  public void setSession(HttpSession session) {
    this.session = session;
  }

  @Override
  public ModelAndView execute(Map<String, String> params) throws IOException {
    session.removeAttribute("user");
    return jspView(REDIRECT + "/");
  }
}