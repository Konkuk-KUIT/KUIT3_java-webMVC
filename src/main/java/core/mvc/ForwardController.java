package core.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardController implements Controller {
    String url;

    public ForwardController(String url) {
        this.url = url;
        if (url == null) {
            throw new NullPointerException("enter the URL to move");
        }
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return url;
    }
}
