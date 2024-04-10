package jwp.controller;

import jwp.constants.JspPath;
import jwp.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController extends AbstractController {

    private final JspPath path;

    public ForwardController(JspPath path) {
        this.path = path;
    }

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        return getJspView(new Request(Type.FORWARD, path));
    }

}
