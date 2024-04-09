package jwp.controller;

import core.db.MemoryUserUserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static core.constant.Uri.USER_LIST;

public class UserListController implements Controller {

  private final MemoryUserUserRepository userRepository;

  public UserListController() {
    this.userRepository = MemoryUserUserRepository.getInstance();
  }

  @Override
  public String doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.setAttribute("userList", userRepository.findAll());
    return USER_LIST.getView();
  }

  @Override
  public String doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return null;
  }
}
