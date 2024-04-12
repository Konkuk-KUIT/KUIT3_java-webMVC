package jwp.mvc.view;

import jwp.constants.JspPath;
import jwp.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class JspView implements View {

    private final Controller.Request request;

    public JspView(Controller.Request request) {
        this.request = request;
    }

    @Override
    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        model.forEach(req::setAttribute);
        if(request.getType() == Controller.Type.REDIRECT) {
            resp.sendRedirect(request.getURL());
            return;
        }
        if(request.getType() == Controller.Type.FORWARD) {
            RequestDispatcher rd = req.getRequestDispatcher(request.getURL());
            rd.forward(req, resp);
        }
    }

}
