package jwp.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 이 서블릿이 처리할 URL 패턴 지정
@WebServlet("/")
public class HomeController extends HttpServlet {
    //HTTP GET 요청을 처리하기 위한 메서드
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // RequestDispatcher => 서블릿 간에 요청을 전달
        // getRequestDispatcher("/home.jsp")를 호출하여 "/home.jsp"로의 요청을 전달할 Dispatcher 객체를 가져옴
        RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
        rd.forward(req, resp);
    }
}
