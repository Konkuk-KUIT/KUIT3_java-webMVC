package core.mvc.view;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class JsonView implements View {
    @Override
    public void render(HashMap<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //jackson라이브러리의 objectMapper 인스턴스로 객체를 json 문자열로 반환
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        // 변환된 json 문자열을 클라이언트에 출력
        PrintWriter out = response.getWriter();
        out.print(mapper.writeValueAsString(model));
    }
}
