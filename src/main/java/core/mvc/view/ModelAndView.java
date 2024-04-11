package core.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

// 응답해줄 값을 유동적으로 만들어서 주자
public class ModelAndView {
    View view;
    Map<String, Object> model = new HashMap<>();

    public ModelAndView addModel(String key, Object val) {
        model.put(key, val);
        return this;
    }

    public ModelAndView(View view){
        this.view = view;
    }
    // 1. Jsp의 경우, request에 model을 저장함.
    // 2. Json의 경우, model → JSON 변환 과정

    public void render(HttpServletRequest request, HttpServletResponse response) throws Exception {
        view.render(model, request, response);
    }


}
