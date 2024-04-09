package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static core.constant.Uri.LOGIN_FAIL;

public class LoginFailureUserController implements Controller {

  @Override
  public String doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return null;
  }

  @Override
  public String doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return LOGIN_FAIL.getView();
  }
}
