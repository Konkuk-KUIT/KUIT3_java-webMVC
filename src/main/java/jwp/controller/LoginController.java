package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginController implements Controller{
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Optional<User> user = MemoryUserRepository.getInstance().findUserByIdAndPassword(request.getParameter("userId"), request.getParameter("password"));
        if(user.isPresent()){
            HttpSession session = request.getSession();
            session.setAttribute("user", user.get());
            return "redirect:/";
        }

        return "/user/login_failed.jsp";

    }
}
