package jwp;

import core.web.filter.ResourceFilter;
import jwp.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
//loadonStartup으로 톰켓 시작시, 우선순위 배정
//controller마다 있던 @WebServlet을 다 떼주고 여기에 모았잖아?
//그러면 그 주소를 requestMapper로 받아서 forward면 forward, redirect면 redirect로 주소를 resp해주는 절차가 필요한듯
//그러면 아팔 어떻게 해야 할까 띵크!
public class DispatcherServlet extends HttpServlet {

    RequestMapper requestMapper;
    public void init() {
        requestMapper = new RequestMapper();
    }

    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        Controller ctrl = requestMapper.getController(req);
        try {
            String viewName = ctrl.execute(req, resp);
            if (viewName.startsWith("redirect:")) {
                resp.sendRedirect(viewName.split(":")[1]);
                return;
            }
            RequestDispatcher rd = req.getRequestDispatcher(viewName);
            rd.forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}
