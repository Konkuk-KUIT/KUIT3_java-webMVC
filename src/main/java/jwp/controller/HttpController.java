package jwp.controller;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpController implements Controller{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Objects.equals(req.getMethod(), "GET")) {
            doGet(req, resp);
            return;
        }
        if(Objects.equals(req.getMethod(), "POST")) {
            doPost(req,resp);
            return;
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 옳지 않은 메서드 어쩌구 저쩌구 처리
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 옳지 않은 메서드 어쩌구 저쩌구 처리
    }
}
