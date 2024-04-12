package jwp.controller;

import core.mvc.ModelAndView;
import core.mvc.view.JsonView;
import core.mvc.view.JspView;
import java.io.IOException;
import java.util.Map;

public class AbstractController implements Controller{

    public ModelAndView jspView(String viewName) {
        return new ModelAndView(new JspView(viewName));
    }
    public ModelAndView jsonView() {
        return new ModelAndView(new JsonView());
    }
    public ModelAndView execute(Map<String, String> paramMap) throws IOException {
        return null;
    }
}
