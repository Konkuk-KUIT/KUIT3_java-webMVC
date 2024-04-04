package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/user/userList")
public class ListUserController implements Controller{
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        Object value = session.getAttribute("user");
//        if (value != null) { //session 이 있는 경우
//            User user = (User) value;
//            req.setAttribute("my", user);
//            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
//            RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
//            rd.forward(req,resp);
//        }
//        //login이 되어 있지 않으면 login화면으로 redirect
//        RequestDispatcher rd = req.getRequestDispatcher("/user/login.jsp");
//        rd.forward(req,resp);
//        //resp.sendRedirect("/user/login");
//    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Object value = session.getAttribute("user");
        if (value != null) { //session 이 있는 경우
            User user = (User) value;
            request.setAttribute("my", user);
            request.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return "/user/list.jsp";
        }
        return "/user/login.jsp";
    }
}
