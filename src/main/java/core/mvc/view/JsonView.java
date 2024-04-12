package core.mvc.view;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class JsonView implements View {

    // 기존 AddAnswerController 에서 Jackson 라이브러리를 활용하던 부분
    @Override
    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ObjectMapper mapper = new ObjectMapper();   // for serialization (object to json)
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String serializedModel = mapper.writeValueAsString(model);  // become to json string
        out.print(serializedModel);
//        System.out.println("serializedModel : " + serializedModel);
//        System.out.println("model : " + model);
    }

}
