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

@WebServlet("/user/updateForm")
public class UpdateUserFormController implements Controller {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id=request.getParameter("userId");
        HttpSession session = request.getSession();
        Object value = session.getAttribute("user");
        if (value != null) {
            User sessionUser = (User) value;
            User user=MemoryUserRepository.getInstance().findUserById(id);
            if(!user.isSameUser(sessionUser)){
                return "redirect:/user/userList";
            }
            else{

                request.setAttribute("user",user);
                return "/user/updateForm.jsp";
            }

        }
        else {
            return "/";
        }

    }
}
