package jwp.controller;

import jwp.util.RequestMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    RequestMapper mapper;
    @Override
    public void init() throws ServletException {
        super.init();
        this.mapper = new RequestMapper();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // uri를 통해서 컨트롤러를 찾는다
        String requestURI = req.getRequestURI();
        Controller controller = this.mapper.requestMapping(requestURI);

        log("requestURI = " + requestURI );
        log("controller = " + controller);

        // 컨트롤러가 처리한 후에 redirect나 forward 수행한다
        try {
            String result = controller.execute(req, resp);

            log("result = " + result);

            if(result.startsWith("redirect:")){
                resp.sendRedirect(result.substring(result.indexOf(":") + 1));
                return;
            }
            RequestDispatcher rd = req.getRequestDispatcher(result);
            rd.forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
