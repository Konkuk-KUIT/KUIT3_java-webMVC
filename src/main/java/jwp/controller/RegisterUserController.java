package jwp.controller;

import core.db.MemoryUserUserRepository;
import core.db.UserRepository;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static core.constant.Uri.LOGIN;
import static core.constant.Uri.USER_REGISTER;

public class RegisterUserController implements Controller {

  private final UserRepository userRepository;

  public RegisterUserController() {
    this.userRepository = MemoryUserUserRepository.getInstance();
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
