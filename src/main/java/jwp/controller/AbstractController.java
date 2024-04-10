package jwp.controller;

import core.mvc.Controller;
import core.mvc.ModelAndView;

public interface AbstractController extends Controller {
    abstract ModelAndView jspView(String url);

    abstract ModelAndView jsonView();

}
