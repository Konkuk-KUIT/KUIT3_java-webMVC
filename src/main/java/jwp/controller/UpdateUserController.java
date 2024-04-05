package jwp.controller;

import core.db.MemoryUserRepository;
import core.db.Repository;
import jwp.model.User;
import jwp.model.dto.UpdateUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static core.constant.Uri.USER_LIST;
import static core.constant.Uri.USER_UPDATE;

public class UpdateUserController implements Controller {

  private final Repository userRepository;

  public UpdateUserController() {
    this.userRepository = MemoryUserRepository.getInstance();
  }

  @Override
  public String doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String userId = (String) request.getSession(true).getAttribute("userId");

    User user = userRepository.findUserById(userId)
        .orElseThrow(() -> new RuntimeException("회원을 찾을 수 없습니다."));

    request.setAttribute("user", user);
    return USER_UPDATE.getView();
  }

  @Override
  public String doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String userId = (String) request.getSession(true).getAttribute("userId");

    UpdateUser requestUser = UpdateUser.from(request);

    User user = userRepository.findUserById(userId)
        .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

    user.update(requestUser);
    userRepository.changeUserInfo(user);

    return REDIRECT_PREFIX + USER_LIST.getUri();
  }
}
