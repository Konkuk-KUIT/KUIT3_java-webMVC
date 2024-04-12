package core.mvc.view;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface View {
    void render(HttpServletRequest req, HttpServletResponse resp, Map<String, Object> model) throws IOException, ServletException;
}
