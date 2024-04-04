package jwp.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyView {

    private String viewPath;
    private String redirectPath = null;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    public MyView redirect(String redirectPath) {
        this.redirectPath = redirectPath;
        return this;
    }

    public void render(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (redirectPath != null) {
            resp.sendRedirect(redirectPath);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
            dispatcher.forward(req, resp);
        }
    }
}
