package jwp.mvc;

import jwp.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static jwp.mvc.RequestMapper.createController;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
    private String url;
    private Controller controller;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller = createController(req.getRequestURI());

        try {
            url = controller.execute(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(url.startsWith("redirect:")){
            resp.sendRedirect(url.replace("redirect:", ""));
        } else {
            RequestDispatcher rd = req.getRequestDispatcher(url);
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller = createController(req.getRequestURI());

        try {
            url = controller.execute(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(url.startsWith("redirect:")){
            resp.sendRedirect(url.replace("redirect:", ""));
        } else {
            RequestDispatcher rd = req.getRequestDispatcher(url);
            rd.forward(req, resp);
        }
    }
}
