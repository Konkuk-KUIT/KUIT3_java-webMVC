package core.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private view View;
    Map<String, Object> model = new HashMap<>();

    public ModelAndView(view View){
        this.View = View;
    }
    public void render(HttpServletRequest req, HttpServletResponse resp){
        try {
            View.render(this.model, req, resp);
        }catch (Exception e){
            System.out.println("Model and View error : "+e);
        }
    }
    public void putModel(String key, Object value){
        this.model.put(key,value);
    }

    public ModelAndView addModel(String key, Object value){
        putModel(key,value);
        return this;
    }
    public ModelAndView addModel(Map<String , Object> model){
        this.model = model;
        return this;
    }



}
