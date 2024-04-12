package core.mvc;

import core.mvc.view.JsonView;
import core.mvc.view.JspView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractController implements Controller{
    protected ModelAndView jspView(String viewName) {
        return new ModelAndView(new JspView(viewName));
    }
    protected ModelAndView jsonView() {
        return new ModelAndView(new JsonView());
    }
}