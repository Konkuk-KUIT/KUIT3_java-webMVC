package core.mvc.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


public class ModelAndView {
    View view;
    HashMap<String, Object> model = new HashMap<>();

    public ModelAndView(View view) {
        this.view = view;
    }

    public ModelAndView addAttribute(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        view.render(model, request, response);
    }
}
