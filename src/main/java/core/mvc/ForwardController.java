package core.mvc;

import core.mvc.view.JSPView;
import core.mvc.view.View;
import jwp.controller.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController extends AbstractController {
    private String forwardUrl;

    public ForwardController(String forwardUrl) {
        this.forwardUrl = forwardUrl;
        if (forwardUrl == null) {
            throw new NullPointerException("forwardUrl is null. 이동할 URL을 입력하세요.");
        }
    }
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp){
        return new JSPView(forwardUrl);
    }
}