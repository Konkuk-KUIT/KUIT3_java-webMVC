package core.mvc.view;

import core.mvc.Controller;

public abstract class AbstractController implements Controller {

  public ModelAndView jsonView() {
    return ModelAndView.of(new JsonView());
  }

  public ModelAndView jspView(String viewName) {
    return ModelAndView.of(JspView.of(viewName));
  }
}
