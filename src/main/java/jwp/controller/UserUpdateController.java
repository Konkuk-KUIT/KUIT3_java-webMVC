package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/user/update")
//public class UserUpdateController extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        MemoryUserRepository repository = MemoryUserRepository.getInstance();
//        User user = repository.findUserById(req.getParameter("userId"));
//        if(user != null){
//            user.update(new User("", req.getParameter("password"), req.getParameter("name"), req.getParameter("email")));
//        }
//        resp.sendRedirect("/user/userList");
//    }
//}


public class UserUpdateController implements Controller{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        MemoryUserRepository repository = MemoryUserRepository.getInstance();
        User user = repository.findUserById(req.getParameter("userId"));
        if(user != null){
            user.update(new User("", req.getParameter("password"), req.getParameter("name"), req.getParameter("email")));
        }
        return "redirect:/user/userList";
    }
}