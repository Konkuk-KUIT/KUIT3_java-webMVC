package core.mvc.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonView implements View{

    public JsonView() {

    }

    @Override
    public void render(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //jsp로 이동
        return;
    }
}
