package jwp.controller;

import jwp.constants.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller {

    private final JspPath path;

    public ForwardController(JspPath path) {
        this.path = path;
    }

    @Override
    public Request execute(HttpServletRequest req, HttpServletResponse resp) {
        return new Request(Type.FORWARD, path);
    }

}
