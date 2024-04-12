package core.mvc;

import core.mvc.view.JspView;

import java.util.Map;

public class ForwardController implements Controller {
    private String forwardUrl;

    public ForwardController(String forwardUrl) {
        this.forwardUrl = forwardUrl;
        if (forwardUrl == null) {
            throw new NullPointerException("forwardUrl is null. 이동할 URL을 입력하세요.");
        }
    }
    @Override
    public ModelAndView execute(Map<String, String> params) {
        return new ModelAndView(new JspView(forwardUrl));
    }
}