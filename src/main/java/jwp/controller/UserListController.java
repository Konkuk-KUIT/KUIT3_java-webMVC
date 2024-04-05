package jwp.controller;

import core.db.MemoryUserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static core.constant.Uri.USER_LIST;

public class UserListController implements Controller {

  private final MemoryUserRepository userRepository;

  public UserListController() {
    this.userRepository = MemoryUserRepository.getInstance();
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
