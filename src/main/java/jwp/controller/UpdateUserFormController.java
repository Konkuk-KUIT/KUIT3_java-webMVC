package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.view.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.model.User;

import java.io.IOException;
import java.util.Map;

public class UpdateUserFormController extends AbstractController {
  // private HttpSession session;

  @Override
  public ModelAndView execute(Map<String, String> params) throws IOException {
    String userId = params.get("userId");
    User user = MemoryUserRepository.getInstance().findUserById(userId);
    if (user != null) {
      return jspView("/user/updateForm.jsp")
        .addModel("user", user);
    }
    return jspView(REDIRECT + "/");
  }

//    @Override
//    public void setSession(HttpSession session) {
//        this.session = session;
//    }
}