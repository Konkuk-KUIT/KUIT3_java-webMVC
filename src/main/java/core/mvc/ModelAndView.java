package core.mvc;

import core.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    View view;
    Map<String, Object> model = new HashMap<>();

    public ModelAndView(View view){
        this.view = view;
    }

    public ModelAndView addModel(String key, Object val){
        model.put(key, val);
        return this; // 메소드 체이닝
    }

    public void render(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Map<String, Object> model = this.model;
        view.render(model, req, resp);
    }
}
