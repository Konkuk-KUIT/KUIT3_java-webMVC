package core.mvc;

import core.mvc.view.JsonView;
import core.mvc.view.JspView;

public abstract class AbstractController implements Controller {
    protected ModelAndView JspView(String url) {
        return new ModelAndView(new JspView(url));
    }

    protected ModelAndView JsonView() {
        return new ModelAndView(new JsonView());
    }
}