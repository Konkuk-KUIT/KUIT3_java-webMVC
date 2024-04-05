package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;
import jwp.model.dto.LoginUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static core.constant.Uri.*;

public class LoginUserController implements Controller {

  private final MemoryUserRepository userRepository;

  public LoginUserController() {
    this.userRepository = MemoryUserRepository.getInstance();
  }

  @Override
  public String doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return LOGIN.getView();
  }

  @Override
  public String doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
    LoginUser loginUser = LoginUser.of(
        request.getParameter("userId"),
        request.getParameter("password"));

    User user = userRepository.findUserById(loginUser.getUserId())
        .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

    if (!user.matchPassword(loginUser.getPassword())) {
      return REDIRECT_PREFIX + LOGIN_FAIL.getUri();
    }

    HttpSession session = request.getSession();
    session.setAttribute("userId", user.getUserId());
    return REDIRECT_PREFIX + HOME.getUri();
  }
}
