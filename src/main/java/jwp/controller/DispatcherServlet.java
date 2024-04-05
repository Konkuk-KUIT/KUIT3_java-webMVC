package jwp.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)      //loadOnStartup : 컨테이너 실행 시 서블릿이 로드되는 순서 지정
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
