package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller{

    private String url;
    public ForwardController(String url) {
        this.url = url;
        if (url == null) {
            throw new NullPointerException("forwardUrl is null. 이동할 URL을 입력하세요.");
        }
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return url;
    }
}
