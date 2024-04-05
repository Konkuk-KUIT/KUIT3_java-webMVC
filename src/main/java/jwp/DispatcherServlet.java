package jwp;

import core.web.filter.ResourceFilter;
import jwp.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
//loadonStartup으로 톰켓 시작시, 우선순위 배정
//controller마다 있던 @WebServlet을 다 떼주고 여기에 모았잖아?
//그러면 그 주소를 requestMapper로 받아서 forward면 forward, redirect면 redirect로 주소를 resp해주는 절차가 필요한듯
//그러면 아팔 어떻게 해야 할까 띵크!
public class DispatcherServlet extends HttpServlet {

    private RequestMapper requestMapper;
    private ResourceFilter resourceFilter;

    public void init() throws ServletException {
        RequestMapper requestMapper = new RequestMapper();

    }

}
