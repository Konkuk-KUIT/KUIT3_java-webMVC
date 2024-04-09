package jwp.controller;

import core.db.MemoryUserUserRepository;
import core.db.UserRepository;
import jwp.model.User;
import jwp.model.dto.UpdateUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static core.constant.Uri.USER_LIST;
import static core.constant.Uri.USER_UPDATE;
import static core.constant.UserField.USER_ID;

public class UpdateUserController implements Controller {

  private final UserRepository userRepository;

  public UpdateUserController() {
    this.userRepository = MemoryUserUserRepository.getInstance();
  }

  @Override
  public String doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String userId = (String) request.getSession(true).getAttribute(USER_ID.getKey());

    User user = userRepository.findUserById(userId)
        .orElseThrow(() -> new RuntimeException("회원을 찾을 수 없습니다."));

    request.setAttribute("user", user);
    return USER_UPDATE.getView();
  }

  @Override
  public String doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String userId = (String) request.getSession(true).getAttribute(USER_ID.getKey());

    UpdateUser requestUser = UpdateUser.from(request);

    User user = userRepository.findUserById(userId)
        .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

    user.update(requestUser);
    userRepository.changeUserInfo(user);

    return REDIRECT_PREFIX + USER_LIST.getUri();
  }
}
