package jwp.model.dto;

import javax.servlet.http.HttpServletRequest;

public class UpdateUser {
  private final String password;
  private final String name;
  private final String email;

  private UpdateUser(String password, String name, String email) {
    this.password = password;
    this.name = name;
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public static UpdateUser from(HttpServletRequest request) {
    return new UpdateUser(
        request.getParameter("password"),
        request.getParameter("name"),
        request.getParameter("email")
    );
  }
}
