package core.mvc.view;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class JsonView implements View{
    //createModel로 들어오는 데이터를 Map으로 담아서 Map에 있는 걸 그대로 Json데이터롤 바꿔주는 작업. 바꿔서 내보내기까지 함.
    //ModelAndView를 반환해야하는가? 나중에 abstractController에서 쓴다고 하니...
    @Override
    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //디버깅
        model.forEach((key, value) -> System.out.println(key + " : " + value));
        out.print(mapper.writeValueAsString(model));
    }
}
