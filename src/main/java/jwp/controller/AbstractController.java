package jwp.controller;

import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.view.JsonView;
import core.view.JspView;

public abstract class AbstractController implements Controller {
    public ModelAndView jspView(String url) {
        return new ModelAndView(new JspView(url));
    }

    public ModelAndView jsonView() {
        return new ModelAndView(new JsonView());
    }
}
