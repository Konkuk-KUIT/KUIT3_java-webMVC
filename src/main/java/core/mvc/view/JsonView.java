package core.mvc.view;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JsonView implements View{
    private static final Logger logger = Logger.getLogger(JsonView.class.getName());

    //public JsonView() {}

    @Override
    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // Jackson 라이브러리 활용
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //out.print(mapper.writeValueAsString(req.getAttribute("answer")));
        //out.print(mapper.writeValueAsString(createModel(req))); //실행이 안됨 왜지

        //model의 값들을 json으로 변환
        out.print(mapper.writeValueAsString(model));
        //return;
    }

    private Map<String, Object> createModel(HttpServletRequest req) {
        Enumeration<String> names = req.getAttributeNames();
        Map<String, Object> model = new HashMap<>();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            logger.log(Level.INFO, name); //실행결과 INFO: answer
            model.put(name, req.getAttribute(name));
            logger.log(Level.INFO, name);
        }
        return model;
    }
}
