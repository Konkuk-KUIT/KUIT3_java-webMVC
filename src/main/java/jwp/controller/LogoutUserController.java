package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static core.constant.Uri.HOME;

public class LogoutUserController implements Controller {

  @Override
  public String doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.getSession().removeAttribute("userId");
    return REDIRECT_PREFIX + HOME.getUri();
  }

  @Override
  public String doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return null;
  }
}
