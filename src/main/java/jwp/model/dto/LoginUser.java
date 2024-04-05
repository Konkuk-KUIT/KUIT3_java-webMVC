package jwp.model.dto;

public class LoginUser {
  private final String userId;
  private final String password;

  private LoginUser(String userId, String password) {
    this.userId = userId;
    this.password = password;
  }

  public String getUserId() {
    return userId;
  }

  public String getPassword() {
    return password;
  }

  public static LoginUser of(String userId, String password) {
    return new LoginUser(userId, password);
  }
}
