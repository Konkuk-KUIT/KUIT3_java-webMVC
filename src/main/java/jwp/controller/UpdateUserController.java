package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.Util.LoginUtil;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//@WebServlet("/user/update")
public class UpdateUserController extends HTTPController {
    @Override
    protected String doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        HttpSession userSession = req.getSession();
        if(!LoginUtil.isLogin(userSession)){
            return REDIRECT+"/user/login";
        }
        User checkUser = (User)userSession.getAttribute("user");
        if(!id.equals(checkUser.getUserId())){
            //잘못된 접근
            return REDIRECT+"/";
        }

        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));
        System.out.println(user.toString());
        MemoryUserRepository.getInstance().findUserById(user.getUserId()).update(user);
        return REDIRECT + "/user/userList";
        //resp.sendRedirect("/user/userList");
    }
}
