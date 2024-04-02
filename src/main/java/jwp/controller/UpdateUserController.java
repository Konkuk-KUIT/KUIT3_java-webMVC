package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/user/update")
public class UpdateUserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        HttpSession userSession = req.getSession();
        if(userSession == null || userSession.getAttribute("user") == null ){
            resp.sendRedirect("/user/login.jsp");
            return;
        }
        User checkUser = (User)userSession.getAttribute("user");
        if(!id.equals(checkUser.getUserId())){
            //잘못된 접근
            resp.sendRedirect("/");
            return;
        }


        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));
        System.out.println(user.toString());
        MemoryUserRepository.getInstance().findUserById(user.getUserId()).update(user);

        resp.sendRedirect("/user/userList");
    }
}
