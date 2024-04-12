package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import core.mvc.view.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class ListUserController extends AbstractController {

  private HttpSession session;

  @Override
  public void setSession(HttpSession session) {
    this.session = session;
  }

  @Override
  public ModelAndView execute(Map<String, String> params) throws IOException {
    if (UserSessionUtils.isLogined(session)) {
      return jspView("/user/list.jsp")
        .addModel("users", MemoryUserRepository.getInstance().findAll());
    }
    return jspView(REDIRECT + "/user/loginForm");
  }
}
