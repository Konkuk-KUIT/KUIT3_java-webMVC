package jwp.controller;

import core.db.MemoryUserRepository;

import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import jwp.Util.LoginUtil;

import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import java.io.IOException;
//@WebServlet("/user/update")
public class UpdateUserController extends HTTPController {
    @Override
    protected ModelAndView doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        HttpSession userSession = req.getSession();
        if(!LoginUtil.isLogin(userSession)){
            return new ModelAndView( new JspView(REDIRECT+"/user/login"));
        }
        User checkUser = (User)userSession.getAttribute("user");
        if(!id.equals(checkUser.getUserId())){
            //잘못된 접근
            return new ModelAndView( new JspView(REDIRECT+"/"));
        }


/*import java.io.IOException;

public class UpdateUserController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
>>>>>>> upstream/week4_step3-qna*/
        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));

        System.out.println(user.toString());
        MemoryUserRepository.getInstance().findUserById(user.getUserId()).update(user);
        return new ModelAndView( new JspView(REDIRECT+"/user/userList"));
        //resp.sendRedirect("/user/userList");
/*=======

        MemoryUserRepository.getInstance().changeUserInfo(user);

        return REDIRECT + "/user/userList";
>>>>>>> upstream/week4_step3-qna*/
    }
}
