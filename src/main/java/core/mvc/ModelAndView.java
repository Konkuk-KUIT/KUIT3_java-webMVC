package core.mvc;

import core.mvc.view.View;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModelAndView{

    View view;
    Map<String, Object> model = new HashMap<>();

    public ModelAndView(View view){
        this.view = view;
    }

    public ModelAndView setAttribute(String key, Object val){
        this.model.put(key, val);
        return this;
    }

    public void render(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        view.render(req, resp, model);
    }

    private
}