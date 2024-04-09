package jwp.controller;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpController implements Controller{

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Objects.equals(req.getMethod(), "GET")) {
            return doGet(req, resp);
        }
        if(Objects.equals(req.getMethod(), "POST")) {
            return doPost(req,resp);
        }
        return "/";
    }

    protected String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 옳지 않은 메서드 어쩌구 저쩌구 처리
        return "/";
    }

    protected String doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 옳지 않은 메서드 어쩌구 저쩌구 처리
        System.out.println("잘못된 메서드의 접근");
        return "/";
    }
}
