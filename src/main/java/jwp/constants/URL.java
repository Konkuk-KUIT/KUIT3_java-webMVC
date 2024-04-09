package jwp.constants;

public enum URL {

    HOME("/"),
    USER_LOGIN("/user/login"),
    USER_LOGOUT("/user/logout"),
    USER_SIGNUP("/user/signup"),
    USER_UPDATE_FORM("/user/updateForm"),
    USER_LIST("/user/userList"),
    QNA_FORM("/qna/form"),
    QNA_SHOW("/qna/show");

    private final String url;

    URL(String url) {
        this.url = url;
    }

    public String get() {
        return url;
    }

}
