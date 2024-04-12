package core.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {

  private View view;
  private Map<String, Object> models = new HashMap<>();

  private ModelAndView(View view) {
    this.view = view;
  }

  public ModelAndView addModel(String key, Object value) {
    models.put(key, value);
    return this;
  }

  public void render(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    view.render(models, req, resp);
  }

  public static ModelAndView of(View view) {
    return new ModelAndView(view);
  }
}
