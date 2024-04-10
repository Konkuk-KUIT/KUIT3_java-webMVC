package core.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class AbstractController implements Controller {

    public final String JSON = "json";
    public ModelAndView jspView(String viewName,Map<String,Object> map){
        View view=new View(viewName);

        return getModelAndView(map, view);
    }

    public ModelAndView jsonView(Map<String,Object> map){
        View view=new View(JSON);

        return getModelAndView(map, view);
    }

    private ModelAndView getModelAndView(Map<String, Object> map, View view) {
        ModelAndView mav = new ModelAndView(view);
        if(map==null){
            return mav;
        }
        for (String key : map.keySet()) {
            mav.addModel(key, map.get(key));
        }
        return mav;
    }

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        throw new RuntimeException("구현되지 않았습니다");
    }
}
