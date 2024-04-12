package jwp.controller;

import core.mvc.Controller;
import core.mvc.view.JSPView;
import core.mvc.view.JsonView;
import core.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AbstractController implements Controller {

    public ModelAndView JSPView(String url){
        return new ModelAndView(new JSPView(url));
    }
    public ModelAndView JSONView(){
        return new ModelAndView(new JsonView());
    }
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        return null;
    }
}
