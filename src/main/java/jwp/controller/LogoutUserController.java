package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static core.constant.Uri.HOME;
import static core.constant.UserField.USER_ID;

public class LogoutUserController implements Controller {

  @Override
  public String doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.getSession().removeAttribute(USER_ID.getKey());
    return REDIRECT_PREFIX + HOME.getUri();
  }

  @Override
  public String doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return null;
  }
}
