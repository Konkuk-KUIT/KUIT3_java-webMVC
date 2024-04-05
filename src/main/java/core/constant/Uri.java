package core.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Uri {
  HOME("/", "/home.jsp"),
  USER_REGISTER("/user/register", "/user/register.jsp"),
  LOGIN("/user/login", "/user/login.jsp"),
  LOGIN_FAIL("/user/login/fail", "/user/login_failed.jsp"),
  LOGOUT("/user/logout", null),
  USER_UPDATE("/user/update", "/user/update.jsp"),
  USER_LIST("/user/list", "/user/list.jsp");

  private final String uri;
  private final String view;
  private static final Map<String, Uri> map = new HashMap<>();

  static {
    for (Uri u : Uri.values()) {
      map.put(u.getUri(), u);
    }
  }

  Uri(String uri, String view) {
    this.uri = uri;
    this.view = view;
  }

  public String getView() {
    return view;
  }

  public String getUri() {
    return uri;
  }

  public static Optional<Uri> get(String uriString) {
    return Optional.ofNullable(map.get(uriString));
  }
}
