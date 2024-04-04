package jwp.controller;

import core.db.MemoryUserRepository;

import jwp.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/user/signup")
public class CreateUserController implements Controller{
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        User user = new User(req.getParameter("userId"),
//                req.getParameter("password"),
//                req.getParameter("name"),
//                req.getParameter("email"));
//
//        MemoryUserRepository.getInstance().addUser(user);
//
//        //execute(req, resp);
//        resp.sendRedirect("/");
//    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = new User(request.getParameter("userId"),
                request.getParameter("password"),
                request.getParameter("name"),
                request.getParameter("email"));

        MemoryUserRepository.getInstance().addUser(user);
        //return "redirect:/";
        return "/";
    }
}
