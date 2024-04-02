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
public class UpdateUserFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        HttpSession userSession = req.getSession();
        if(userSession == null || userSession.getAttribute("user") == null ){
            resp.sendRedirect("/user/login.jsp");
            return;
        }
        User user = (User)userSession.getAttribute("user");
        if(!id.equals(user.getUserId())){
            //잘못된 접근
            resp.sendRedirect("/");
            return;
        }
        req.setAttribute("user", MemoryUserRepository.getInstance().findUserById(id));
        RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
        //System.out.print("i get val to . userId:"+MemoryUserRepository.getInstance().findUserById(id).userId);
        rd.forward(req,resp);
    }
}
