package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller{
    private String url;
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return url;
    }

    ForwardController(String url){
        this.url = url;

    }
}
