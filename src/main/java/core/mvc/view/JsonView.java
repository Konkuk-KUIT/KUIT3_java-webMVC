package core.mvc.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Slf4j
public class JsonView implements View{
    @Override
    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("JsonView");

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        for (Object object : model.values()) {
            out.print(mapper.writeValueAsString(object));
        }
    }
}