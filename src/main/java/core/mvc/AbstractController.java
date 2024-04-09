package core.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class AbstractController implements Controller {
    public ModelAndView jspView(String viewName){
        View view=new View(viewName);
        return new ModelAndView(view);
    }

    public ModelAndView jsonView(Map<String,Object> map){
        View view=new View("json");
        ModelAndView mav = new ModelAndView(view);
        for (String key : map.keySet()) {
            mav.addModel(key,map.get(key));
        }
        return mav;
    }

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        throw new RuntimeException("구현되지 않았습니다");
    }
}
