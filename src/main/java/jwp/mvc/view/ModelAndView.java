package jwp.mvc.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {

    private final Map<String, Object> model = new HashMap<>();
    private final View view;

    public ModelAndView(View view) {
        this.view = view;
    }

    public void addModel(String key, Object obj) {
        model.put(key, obj);
    }

    public void render(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        view.render(model, req, resp);
    }

}
