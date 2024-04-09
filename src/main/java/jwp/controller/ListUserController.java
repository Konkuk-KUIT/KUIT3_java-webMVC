package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListUserController implements Controller {



    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");
        User user = (User) value;

        if (user!=null) {
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            req.setAttribute("currentUser", user);
            return "/user/list.jsp";
        }
        req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
        return "login.jsp";
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        Object value = session.getAttribute("user");
//        User user = (User) value;
//        if (user != null) {
//            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
//            RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
//            rd.forward(req,resp);
//            return;
//        }
//        resp.sendRedirect("/");
//
//    }
}


