package core.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {

    View view;
    Map<String, Object> model = new HashMap<>();

    public ModelAndView(View view) {
        this.view = view;
    }

    public void addModel(String key, Object val) {
        model.put(key,val);
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws Exception {
        view.render(request, response);
    }
}