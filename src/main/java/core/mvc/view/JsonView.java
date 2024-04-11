package core.mvc.view;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class JsonView implements View {

    @Override
    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=UTF-8");
        // 응답해 주는 부분 추가
        PrintWriter out = resp.getWriter();
        out.print(mapper.writeValueAsString(model));
    }
//    private Map<String, Object> createModel(HttpServletRequest request) {
//        // 정보를 읽어와서 넘겨주는 역할
//        Enumeration<String> names = request.getAttributeNames();
//        Map<String, Object> model = new HashMap<>();
//
//        while(names.hasMoreElements()){
//            String name = names.nextElement();
//            model.put(name, request.getAttribute(name));
//        }
//        return model;
//    }
}