package jwp.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)      //loadOnStartup : 컨테이너 실행 시 서블릿이 로드되는 순서 지정
public class DispatcherServlet extends HttpServlet {
    private RequestMapper requestMapper;
    private String redirect = "redirect:";
    @Override
    public void init() throws ServletException {
        this.requestMapper = new RequestMapper();
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Controller controller = requestMapper.getController(req);
        try {
            String view = controller.execute(req, resp);
            if(view.startsWith("redirect:")){
                resp.sendRedirect(view.substring(redirect.length()));
                return;
            }
            RequestDispatcher rd = req.getRequestDispatcher(view);
            rd.forward(req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
