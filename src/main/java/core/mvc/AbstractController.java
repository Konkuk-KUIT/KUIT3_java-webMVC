package core.mvc;

import core.mvc.view.JsonView;
import core.mvc.view.JspView;

public abstract class AbstractController implements Controller{
    public ModelAndView jspModelAndView(String viewName) {
        JspView jspView = new JspView(viewName);
        return new ModelAndView(jspView);
    }

    public ModelAndView jsonModelAndView() {
        JsonView jsonView = new JsonView();
        return new ModelAndView(jsonView);
    }
}
