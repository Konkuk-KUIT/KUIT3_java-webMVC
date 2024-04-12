package core.mvc.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        return this; //메소드 체이닝 기법
    }

    public void render(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        view.render(model, req, resp);
    }
}
