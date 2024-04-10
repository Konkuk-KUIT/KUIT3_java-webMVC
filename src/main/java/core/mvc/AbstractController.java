package core.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public abstract class AbstractController implements Controller {

    public final String JSON = "json";
    public ModelAndView jspView(String viewName){
        View view=new View(viewName);

        return new ModelAndView(view);

    }

    public ModelAndView jsonView(){
        View view=new View(JSON);

        return new ModelAndView(view);
    }


    @Override
    public ModelAndView execute(Map<String, String> req) throws IOException {
        throw new RuntimeException("구현되지 않았습니다");
    }
}
