package core.mvc.v3.adapter;

import core.mvc.v2.ControllerV2;
import core.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV2HandlerAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV2);
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        ControllerV2 controller = (ControllerV2) handler;
        setControllerFields(request, controller);

        Map<String, String> params = createParamMap(request);
        Map<String, Object> model = new HashMap<>();
        String viewName = controller.execute(params, model);

        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.setModel(model);
        return modelAndView;
    }

}
