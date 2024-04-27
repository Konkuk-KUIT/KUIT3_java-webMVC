package jwp.controller.v3;

import core.mvc.v2.ControllerV2;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class ForwardControllerV2 implements ControllerV2 {
    private String forwardUrl;

    public ForwardControllerV2(String forwardUrl) {
        this.forwardUrl = forwardUrl;
        if (forwardUrl == null) {
            throw new NullPointerException("forwardUrl is null. 이동할 URL을 입력하세요.");
        }
    }
    @Override
    public String execute(Map<String, String> params, Map<String, Object> model) throws IOException {
        log.info("ForwardControllerV2");
        return forwardUrl;
    }
}