package core.mvc.view;

import core.mvc.Controller;
import core.mvc.ModelAndView;

public abstract class AbstractController implements Controller {
    public ModelAndView jsonView(){
        JsonView jsonView=new JsonView();
        return new ModelAndView(jsonView);
    }
    public ModelAndView jspView(String url){
        JspView jspView=new JspView(url);
        return new ModelAndView(jspView);
    }


}
