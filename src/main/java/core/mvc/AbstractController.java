package core.mvc;

import core.mvc.view.JsonView;
import core.mvc.view.JspView;

import java.util.Map;

public abstract class AbstractController implements Controller {
    protected ModelAndView jspView(String forwardUrl) {
        JspView view = new JspView(forwardUrl);
        return new ModelAndView(view);
    }

    protected ModelAndView jsonView(Map<String, Object> map) {
        JsonView view = new JsonView();
        return new ModelAndView(view);
    }
}
