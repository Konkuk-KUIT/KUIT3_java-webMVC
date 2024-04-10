package jwp.controller;

import jwp.controller.Controller;
import jwp.mvc.view.JsonView;
import jwp.mvc.view.JspView;
import jwp.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController implements Controller {

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    protected ModelAndView getJspView(Request request) {
        return new ModelAndView(new JspView(request));
    }

    protected ModelAndView getJsonView() {
        return new ModelAndView(new JsonView());
    }

}
