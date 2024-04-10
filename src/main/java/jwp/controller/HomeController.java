package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


public class HomeController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return "/home.jsp";
    }
}

//RequestDispatcher에 대해...
//리퀘스트에 담긴 정보를 저장하고 있다가 다음 페이지에서도 해당 정보를 볼 수 있게 해주는거
//forward는 정보를 담아서 다음 페이지로 넘겨주고, sendRedirect는 그냥 페이지만 호출할 수 있게 해주는 메서드
//forward할 때 reqest에 setAttribute를 통해 넘길 정보를 저장한 후에 response로 넘겨주는 듯.
//따라서 저장하고 싶은 정보가 있으면 setAttribute로 request에 달아주기.

//알아버린 사실 ! : html에서 body 부분에 method="post"해주면 post방식으로 바꿀 수 있나보다!
