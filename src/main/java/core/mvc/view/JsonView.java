package core.mvc.view;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class JsonView implements View{

    public JsonView() {}

    @Override
    public void render(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // model을 json으로 변환
        //jsp로 이동
        // Jackson 라이브러리 활용
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(mapper.writeValueAsString(req.getAttribute("savedAnswer")));
        return;
    }
}
