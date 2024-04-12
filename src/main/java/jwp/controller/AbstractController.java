package jwp.controller;

import core.mvc.ModelAndView;
import core.mvc.view.JsonView;
import core.mvc.view.JspView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AbstractController implements Controller{

    public ModelAndView jspView(String viewName) {
        return new ModelAndView(new JspView(viewName));
    }
    public ModelAndView jsonView() {
        return new ModelAndView(new JsonView());
    }
    public ModelAndView execute(HttpServletRequest req) throws IOException {
        return null;
    }
}
