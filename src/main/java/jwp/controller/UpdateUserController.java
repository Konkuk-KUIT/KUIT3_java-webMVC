package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/user/update")
public class UpdateUserController implements Controller{
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //수정된 user 데이터 update
//        User user = new User(req.getParameter("userId"),
//                req.getParameter("password"),
//                req.getParameter("name"),
//                req.getParameter("email"));
//        MemoryUserRepository.getInstance().changeUserInfo(user);
//
//        resp.sendRedirect("/user/userList");
//    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = new User(request.getParameter("userId"),
                request.getParameter("password"),
                request.getParameter("name"),
                request.getParameter("email"));
        MemoryUserRepository.getInstance().changeUserInfo(user);

        return "redirect:/user/userList";
    }
}
