package core.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.mvc.view.JspView;
import core.mvc.view.View;
import core.mvc.view.JspView;

public class ForwardController implements Controller {
    private String forwardUrl;

    public ForwardController(String forwardUrl) {
        this.forwardUrl = forwardUrl;
        if (forwardUrl == null) {
            throw new NullPointerException("forwardUrl is null. 이동할 URL을 입력하세요.");
        }
    }
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp){
    // 동적 페이지 반환
        return new JspView(forwardUrl);
    }
}