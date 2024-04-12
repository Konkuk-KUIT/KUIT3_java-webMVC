package core.mvc;

import core.mvc.view.JspView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import core.mvc.view.JspView;
import java.io.IOException;

public class ForwardController extends AbstractController {
    private String forwardUrl;

    public ForwardController(String forwardUrl) {
        this.forwardUrl = forwardUrl;
        if (forwardUrl == null) {
            throw new NullPointerException("forwardUrl is null. 이동할 URL을 입력하세요.");
        }
    }
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp)throws IOException {
//        return new JspView(forwardUrl);
        return jspView(forwardUrl);
    }
}