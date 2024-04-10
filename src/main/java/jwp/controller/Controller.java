package jwp.controller;

import core.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {

    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws IOException;

}
