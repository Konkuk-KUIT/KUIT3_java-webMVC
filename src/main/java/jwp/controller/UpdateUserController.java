package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.view.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.model.User;

import java.io.IOException;
import java.util.Map;

public class UpdateUserController extends AbstractController {

  @Override
  public ModelAndView execute(Map<String, String> params) throws IOException {
    User user = new User(params.get("userId"),
      params.get("password"),
      params.get("name"),
      params.get("email"));

    MemoryUserRepository.getInstance().changeUserInfo(user);

    return jspView(REDIRECT + "/user/userList");
  }
}
