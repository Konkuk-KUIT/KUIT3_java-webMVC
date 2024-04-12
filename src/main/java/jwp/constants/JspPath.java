package jwp.constants;

public enum JspPath {

    HOME("/home.jsp"),
    USER_FORM("/user/form.jsp"),
    USER_LIST("/user/list.jsp"),
    USER_LOGIN("/user/login.jsp"),
    USER_LOGIN_FAILED("/user/login_failed.jsp"),
    USER_UPDATE_FORM("/user/updateForm.jsp"),
    QNA_FORM("/qna/form.jsp"),
    QNA_SHOW("/qna/show.jsp");

    private final String path;

    JspPath(String path) {
        this.path = path;
    }

    public String get() {
        return path;
    }

}
