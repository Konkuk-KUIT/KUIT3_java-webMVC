package core.mvc;

import core.mvc.view.View;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    private RequestMapping requestMapping;

    @Override
    public void init() throws ServletException {
        this.requestMapping = new RequestMapping();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Controller controller = requestMapping.getController(req);
        try {
            ModelAndView mav = controller.execute(req, resp);
            if(mav == null) return; // TODO 힌트에는 없는데 없애도 되는건가?
            mav.render(req, resp);
        } catch (Throwable e) {
            throw new ServletException(e.getMessage());
        }
    }

//    private void move(String viewName, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (viewName.startsWith(REDIRECT_PREFIX)) {
//            resp.sendRedirect(viewName.substring(REDIRECT_PREFIX.length()));
//            return;
//        }
//        RequestDispatcher rd = req.getRequestDispatcher(viewName);
//        rd.forward(req, resp);
//    }
}