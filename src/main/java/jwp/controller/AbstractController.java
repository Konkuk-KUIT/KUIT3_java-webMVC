package jwp.controller;

import core.mvc.Controller;
import core.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AbstractController implements Controller {
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        return null;
    }
}
