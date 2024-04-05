package jwp.controller;

import core.db.MemoryUserUserRepository;
import jwp.model.User;
import jwp.model.dto.LoginUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Optional;

import static core.constant.Uri.*;
import static core.constant.UserField.PASSWORD;
import static core.constant.UserField.USER_ID;

public class LoginUserController implements Controller {

  private final MemoryUserUserRepository userRepository;

  public LoginUserController() {
    this.userRepository = MemoryUserUserRepository.getInstance();
  }

  @Override
  public String doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return LOGIN.getView();
  }

  @Override
  public String doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
    LoginUser loginUser = LoginUser.of(
        request.getParameter(USER_ID.getKey()),
        request.getParameter(PASSWORD.getKey()));

    Optional<User> user = userRepository.findUserById(loginUser.getUserId());

    if (user.isEmpty() || !user.get().matchPassword(loginUser.getPassword())) {
      return REDIRECT_PREFIX + LOGIN_FAIL.getUri();
    }

    HttpSession session = request.getSession();
    session.setAttribute(USER_ID.getKey(), user.get().getUserId());
    return REDIRECT_PREFIX + HOME.getUri();
  }
}
