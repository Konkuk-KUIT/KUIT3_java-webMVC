package jwp.controller.front;

import core.constant.Uri;
import jwp.controller.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static core.constant.Uri.*;

public class ControllerMapper {
  private final Map<Uri, Controller> map = new HashMap<>();

  public ControllerMapper() {
    init();
  }

  private void init() {
    map.put(HOME, new HomeController());
    map.put(USER_REGISTER, new RegisterUserController());
    map.put(LOGIN, new LoginUserController());
    map.put(LOGIN_FAIL, new LoginFailureUserController());
    map.put(LOGOUT, new LogoutUserController());
    map.put(USER_UPDATE, new UpdateUserController());
    map.put(USER_LIST, new UserListController());
  }

  public Controller getController(String uriString) {
    Optional<Uri> uri = get(uriString);

    if (uri.isEmpty()) {
      return ForwardController.of(uriString);
    }

    return map.get(uri.get());
  }
}
