package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//controller에
public class ForwardController implements Controller {

    private String urlPath;
    public ForwardController(String urlPath){
        this.urlPath = urlPath;
        if(urlPath.isEmpty()) {
            throw new NullPointerException("잘못된 url주소");
        }
    }
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return urlPath;
    }
}
