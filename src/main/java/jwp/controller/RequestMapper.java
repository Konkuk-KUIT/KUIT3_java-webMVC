package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RequestMapper {
    private String url;
    Map<String, Controller> requestMapper = new HashMap<>();

    public RequestMapper(){
        initRequest();
    }

    public void initRequest(){
        requestMapper.put("/", new HomeController());
        requestMapper.put("/user/login", new LoginController());
        requestMapper.put("/user/logout", new LogoutController());
        requestMapper.put("/user/userList", new ListUserController());
        requestMapper.put("/user/signup", new CreateUserController());
        requestMapper.put("/user/update", new UpdateUserController());
        requestMapper.put("/user/updateForm", new UpdateUserFormController());

        requestMapper.put("/qna/form", new ForwardController("/qna/form.jsp"));
        requestMapper.put("/qna/show", new ForwardController("/qna/show.jsp"));
        requestMapper.put("/user/form", new ForwardController("/user/form.jsp"));
        requestMapper.put("/user/loginForm", new ForwardController("/user/login.jsp"));
        requestMapper.put("/user/loginFailed", new ForwardController("/user/login_failed.jsp"));
    }

    public Controller getController(HttpServletRequest req){
        return requestMapper.get(req.getRequestURI());
    }
}
