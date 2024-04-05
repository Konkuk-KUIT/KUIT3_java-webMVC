package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvcFramework.Controller;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserFormController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String currentId = req.getParameter("userId"); // 쿼리파라미터에서 현재 수정하려는 userId를 가져옴
        User user = MemoryUserRepository.getInstance().findUserById(currentId); // currentId로 User객체를 찾아서 가져옴

        if(user!=null){
            req.setAttribute("user", user);
            return "/user/updateForm.jsp";
        }

        return REDIRCT+"/";
    }
}
