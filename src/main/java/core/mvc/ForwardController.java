package core.mvc;

import core.mvc.view.JSPView;
import core.mvc.view.ModelAndView;
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
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp){
        ModelAndView model = new ModelAndView(new JSPView(forwardUrl));
        return model;
    }
}