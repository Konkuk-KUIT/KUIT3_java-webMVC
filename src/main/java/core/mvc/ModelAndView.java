package core.mvc;

import core.mvc.view.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    //일단 jsp 주소가 될 View와 json데이터에 쓰일 애를 담은 model을 둘다 return해줘버려.어!.그냥 줘버려.
    //model에 addModel로 그냥 줘버려.어!
    View view;
    Map<String, Object> model = new HashMap<>();

    public ModelAndView(View view) {
        this.view = view;
    }

    //데이터 담을 때 이걸 써주자.
    public ModelAndView addModel(String key, Object val) {
        model.put(key, val);
        return this;
    }

    public void render(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        view.render(model, req, resp);
    }
}
