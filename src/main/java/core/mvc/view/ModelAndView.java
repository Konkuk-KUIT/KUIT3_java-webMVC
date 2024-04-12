package core.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private View view;
    private Map<String, Object> model;

    public ModelAndView(View view){
        this.view = view;
        model = new HashMap<>();
    }
    public void render(HttpServletRequest req, HttpServletResponse resp) {
        try {
            view.render(model, req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public ModelAndView addModel(String key, Object value){
        model.put(key, value);
        return this;     // 메소드 체이닝을 사용해야 하는 이유는 무엇일까요??
    }
}
