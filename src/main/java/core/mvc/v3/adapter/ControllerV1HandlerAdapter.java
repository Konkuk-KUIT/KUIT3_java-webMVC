package core.mvc.v3.adapter;

import core.mvc.v1.ControllerV1;
import core.mvc.view.ModelAndView;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class ControllerV1HandlerAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV1);
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        ControllerV1 controller = (ControllerV1) handler;
        setControllerFields(request, controller);

        Map<String, String> params = createParamMap(request);
        ModelAndView modelAndView = controller.execute(params);
        return modelAndView;
    }

}
