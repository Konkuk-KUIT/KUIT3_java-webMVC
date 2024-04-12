package core.mvc.view;

import core.mvc.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface View {
    void render(Model model, HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
