package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/user/login")
public class LoginController implements Controller{
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //user의 정보를 db에서 확인하고 login 여부 가리기
//        User user = MemoryUserRepository.getInstance().findUserById(req.getParameter("userId"));
//        if ((user != null)&&(user.getPassword().equals(req.getParameter("password"))) ){
//            HttpSession session = req.getSession();
//            session.setAttribute("user", user);
//            //왜 foward로 하면 안될까?
//            resp.sendRedirect("/");
//        }else{
//            resp.sendRedirect("/user/login_failed.jsp");
//        }
//    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = MemoryUserRepository.getInstance().findUserById(request.getParameter("userId"));
        if ((user != null)&&(user.getPassword().equals(request.getParameter("password"))) ){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            //return "redirect:/"; //실행안됨 -> 원래는 redirect로 넘겨야 하는 것이 맞음
            return "/"; //이걸로했을때는 실행됨
        }else{
            //return "redirect:/user/login_failed";
            return "/user/login_failed.jsp";
        }
    }
}
