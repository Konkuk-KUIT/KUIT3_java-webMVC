package jwp;

import jwp.controller.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RequestMapper {

    private final Map<String, Controller> controllers = new HashMap<>();

    public RequestMapper(){
        createServlet();
    }

    private void createServlet(){
        //redirect하는 애들 - 나중에 필터로 redirect:는 빼고 뒤에 주소만 해서 jsp로 연결할거기 때문이다.
        controllers.put("/", new HomeController());
        controllers.put("/user/signup", new CreateUserController());
        controllers.put("/user/updateForm", new UpdateUserFormController());
        controllers.put("user/update", new UpdateFormController());
        controllers.put("/user/login", new LoginController());
        controllers.put("/user/userList", new ListUserController());
        controllers.put("/user/logout", new LogoutController());
        //forward하는 애들
        controllers.put("/user/form", new ForwardController("/user/form.jsp"));
        controllers.put("/user/update", new ForwardController("/user/updateForm.jsp"));
        controllers.put("/user/loginForm", new ForwardController("/user/login.jsp"));

    }
    //예를 들어 action으로 /user/form을 받으면 /user/form.jsp를 넘기겠지. 그런데 /user/form.jsp의 액션은 /user/signup이란 말이지?
    //그래서 /user/signup을 받으면 CreateUserController를 실행해야 겠지.  CUC에서 할일을 다하면 /user/userList로 리다이렉트를 하는데,
    //그러면 ListUserController가 실행되고, 그게 끝나면, jsp나 리다이렉트를 하는데 jsp의 액션은 /user/updateForm이고,
    //리다이렉트는 /user/login이기 때문에 다시  loginController를 실행해야 한다.
    //결국 jsp의 액션을 기준으로 어떤 controller를 뿌려야할 지가 결정되기 때문에 jsp파일의 연결을 잘 봐야한다.
}
