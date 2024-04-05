package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet("/user/updateForm")
//public class UserUpdateFormController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        User loginedUser = (User) session.getAttribute("user");
//        String userId = req.getParameter("userId");
//        if(loginedUser.isSameUser(userId)){
//            MemoryUserRepository repository = MemoryUserRepository.getInstance();
//            User user = repository.findUserById(userId);
//            req.setAttribute("user", user);
//            RequestDispatcher rq = req.getRequestDispatcher("/user/updateForm.jsp");
//            rq.forward(req, resp);
//        }
//        resp.sendRedirect("/user/userList");
//    }
//}


public class UserUpdateFormController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        User loginedUser = (User) session.getAttribute("user");
        String userId = req.getParameter("userId");
        if(loginedUser.isSameUser(userId)){
            MemoryUserRepository repository = MemoryUserRepository.getInstance();
            User user = repository.findUserById(userId);
            req.setAttribute("user", user);
            return "/user/updateForm.jsp";
        }
        return "redirect:/user/userList";
    }
}
