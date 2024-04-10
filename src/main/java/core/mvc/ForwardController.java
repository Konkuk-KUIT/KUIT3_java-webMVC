package core.mvc;

import core.mvc.view.JspView;
import core.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller {
    private String forwardUrl;

    public ForwardController(String forwardUrl) {
        this.forwardUrl = forwardUrl;
        if (forwardUrl == null) {
            throw new NullPointerException("forwardUrl is null. 이동할 URL을 입력하세요.");
        }
    }

    // String 대신 이제는 View 반환하도록 변경
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp){

        return new JspView(forwardUrl);
    }
}