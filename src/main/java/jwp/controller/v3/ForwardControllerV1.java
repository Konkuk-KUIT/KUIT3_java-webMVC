package jwp.controller.v3;

import core.mvc.v1.ControllerV1;
import core.mvc.view.ModelAndView;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class ForwardControllerV1 implements ControllerV1 {
    private String forwardUrl;

    public ForwardControllerV1(String forwardUrl) {
        this.forwardUrl = forwardUrl;
        if (forwardUrl == null) {
            throw new NullPointerException("forwardUrl is null. 이동할 URL을 입력하세요.");
        }
    }
    @Override
    public ModelAndView execute(Map<String, String> params){
        log.info("ForwardControllerV1");
        return new ModelAndView(forwardUrl);
    }
}