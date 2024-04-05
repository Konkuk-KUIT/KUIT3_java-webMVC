package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc_framework.Controller;
import jwp.model.User;


import javax.servlet.ServletException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//getParameter - 클라이언트의 HTML 페이지에서 필요한 정보를 얻는 데 사용됩니다.
//
//getAttribute - 이전에 다른 JSP 또는 Servlet 페이지에 설정된 매개 변수를 가져 오는 데 사용됩니다.

public class UpdateUserController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));

        MemoryUserRepository.getInstance().changeUserInfo(user);
        return "/home.jsp";


    }
}
