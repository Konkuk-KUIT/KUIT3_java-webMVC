package core.mvc;

import core.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    Map<String, Object> model = new HashMap<>();
    View view;

    private ModelAndView(View view){
        this.view = view;
    }

    public static ModelAndView from(View view){
        return new ModelAndView(view);
    }

    public ModelAndView addModel(String key, Object value){
        model.put(key, value);
        return this;
    }

    public void render(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        view.render(req, resp, model);
    }
}
