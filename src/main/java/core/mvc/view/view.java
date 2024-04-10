package core.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface view {

    public void render(Map<String,Object> model, HttpServletRequest req, HttpServletResponse resp)throws Exception;
}
