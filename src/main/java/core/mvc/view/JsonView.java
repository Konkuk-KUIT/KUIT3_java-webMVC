package core.mvc.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.mvc.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class JsonView implements View{
    @Override
    public void render(Model model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        // Jackson 라이브러리 활용
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(mapper.writeValueAsString(model.getMap()));
    }

//    private Model createModel(HttpServletRequest req) {
//        Enumeration<String> names = req.getAttributeNames();
//        Model model = new Model();
//        while(names.hasMoreElements()){
//            String name = names.nextElement();
//            model.put(name,req.getAttribute(name));
//        }
//        return model;
//    }
}
