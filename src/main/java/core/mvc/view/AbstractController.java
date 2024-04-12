package core.mvc.view;

import core.mvc.Controller;
import core.mvc.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractController implements Controller {
    public ModelAndView jsonView(){
        JsonView jsonView=new JsonView();
        return new ModelAndView(jsonView);
    }
    public ModelAndView jspView(String url){
        JspView jspView=new JspView(url);
        return new ModelAndView(jspView);
    }


    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        return null;
    }
}
