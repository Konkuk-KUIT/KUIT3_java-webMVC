package core.mvc;

import core.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModelAndView {
    private View view;
    private Model model = new Model();

    public ModelAndView(View view) {
        this.view = view;
    }

    public ModelAndView addModel(String key, Object val){
        model.put(key, val);
        return this;
    }

    public void render(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        view.render(model, req, resp);
    }
}
