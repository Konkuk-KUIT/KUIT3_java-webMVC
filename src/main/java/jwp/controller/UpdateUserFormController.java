package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/user/updateForm")
public class UpdateUserFormController implements Controller{
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //querystring으로 넘어온 userId의 값을 가져옴
//        MemoryUserRepository db = MemoryUserRepository.getInstance();
//        User user = db.findUserById(req.getParameter("userId"));
//        req.setAttribute("user", user);
//        RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
//        rd.forward(req,resp);
//    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MemoryUserRepository db = MemoryUserRepository.getInstance();
        User user = db.findUserById(request.getParameter("userId"));
        request.setAttribute("user", user);
        return "/user/updateForm.jsp";
    }
}
