package core.mvc.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface View {
    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
}
