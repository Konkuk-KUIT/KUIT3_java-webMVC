package core.mvc;

import core.mvc.Controller;
import core.mvc.view.JsonView;
import core.mvc.view.JspView;
import core.mvc.view.ModelandView;

public abstract class AbstractController implements Controller {

    protected ModelandView jspView(String viewname) {
        return new ModelandView(new JspView(viewname));
    }

    protected ModelandView jsonView() {
        return new ModelandView(new JsonView());
    }

}
