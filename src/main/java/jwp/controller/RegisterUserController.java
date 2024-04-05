package jwp.controller;

import core.db.MemoryUserRepository;
import core.db.Repository;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static core.constant.Uri.LOGIN;
import static core.constant.Uri.USER_REGISTER;

public class RegisterUserController implements Controller {

  private final Repository userRepository;

  public RegisterUserController() {
    this.userRepository = MemoryUserRepository.getInstance();
  }

  @Override
  public String doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return USER_REGISTER.getView();
  }

  @Override
  public String doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
    User user = User.from(request);
    userRepository.addUser(user);

    return REDIRECT_PREFIX + LOGIN.getUri();
  }
}
