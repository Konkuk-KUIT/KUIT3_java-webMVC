package core.constant;

public enum UserField {
  USER_ID("userId"),
  PASSWORD("password"),
  NAME("name"),
  EMAIL("email");

  private final String key;

  UserField(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }
}
