package core.mvc;

import core.view.JsonView;
import core.view.JspView;
import core.view.View;
import jwp.controller.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements AbstractController {
    private String forwardUrl;

    public ForwardController(String forwardUrl) {
        this.forwardUrl = forwardUrl;
        if (forwardUrl == null) {
            throw new NullPointerException("forwardUrl is null. 이동할 URL을 입력하세요.");
        }
    }
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp){
        return jspView(forwardUrl);
    }

    @Override
    public ModelAndView jspView(String url) {
        return new ModelAndView(new JspView(url));
    }

    public ModelAndView jsonView() {
        return new ModelAndView(new JsonView());
    }
}