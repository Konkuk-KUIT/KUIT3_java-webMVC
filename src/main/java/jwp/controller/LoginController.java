package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = MemoryUserRepository.getInstance().findUserById(request.getParameter("userId"));
        if ((user != null)&&(user.getPassword().equals(request.getParameter("password"))) ){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "redirect:/";
        }else{

            return "/user/login_failed.jsp";
        }
    }
}
