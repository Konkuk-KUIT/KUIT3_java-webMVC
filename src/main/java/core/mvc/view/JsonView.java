package core.mvc.view;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

public class JsonView implements View {
  @Override
  public void render(Map<String, Object> models, HttpServletRequest req, HttpServletResponse resp) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    resp.setCharacterEncoding(APPLICATION_JSON_UTF8_VALUE);
    PrintWriter writer = resp.getWriter();
    writer.print(mapper.writeValueAsString(models));
  }
}
