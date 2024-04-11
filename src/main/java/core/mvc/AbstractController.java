package core.mvc;

import core.mvc.view.JsonView;
import core.mvc.view.JspView;

public abstract class AbstractController implements Controller {

    // JSP View를 반환하는 메소드
    protected ModelAndView jspView(String forwardUrl) {
        JspView view = new JspView(forwardUrl);
        return new ModelAndView(view);
    }

    // JSON View를 반환하는 메소드
    protected ModelAndView jsonView() {
        JsonView view = new JsonView();
        return new ModelAndView(view);
    }
}
