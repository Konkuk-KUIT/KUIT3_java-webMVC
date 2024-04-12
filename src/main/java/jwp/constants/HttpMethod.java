package jwp.constants;

public enum HttpMethod {

    GET("GET"), POST("POST");

    private final String method;

    HttpMethod(String method) {
        this.method = method;
    }

    public String getString() {
        return method;
    }

}
