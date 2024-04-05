package core.constant;

public enum Method {
  GET("GET"),
  POST("POST");

  private final String key;

  Method(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }
}
