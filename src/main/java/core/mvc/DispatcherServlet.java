package core.mvc;

import core.mvc.view.ModelAndView;
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
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    public void init() throws ServletException {
        this.requestMapping = new RequestMapping();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Controller controller = requestMapping.getController(req);
        try {
            // string이 아니라 View를 return받아야 함
            // String viewName = controller.execute(req, resp);
             View view = controller.execute(req, resp);
//            ModelAndView mav = controller.execute(req, resp);
            // jackson으로 json파일을 보여주므로 페이지를 반환할 것이 없음
            // if(viewName == null) return;
            //move(viewName, req, resp);
            if(view == null) return;
            view.render(req, resp);
        } catch (Throwable e) {
            throw new ServletException(e.getMessage());
        }
    }
}