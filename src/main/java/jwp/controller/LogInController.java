package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import core.mvc.view.view;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogInController extends HTTPController {
    /*@Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User user = MemoryUserRepository.getInstance().findUserById(userId);

        if (user != null && user.isSameUser(userId, password)) {
            session.setAttribute("user", user);
            return new ModelAndView( new JspView(REDIRECT+"/"));
        }
        return new ModelAndView( new JspView(REDIRECT + "/user/loginFailed"));
    }*/
    @Override
    protected ModelAndView doGet(HttpServletRequest req)  {

        return new ModelAndView(new JspView(REDIRECT +"/user/login.jsp"));
    }
    @Override
    protected ModelAndView doPost(HttpServletRequest req){
        User user=MemoryUserRepository.getInstance().findUserById(req.getParameter("userId"));
        if(user==null){
            //resp.sendRedirect("/user/login_failed.jsp");
            return loginFailed();
        }
        //System.out.println(user.toString());
        if(!user.matchPassword(req.getParameter("password"))){
            //resp.sendRedirect("/user/login_failed");
            return loginFailed();
        }
        // 세션 정보 저장
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        return new ModelAndView(new JspView(REDIRECT +"/"));
        //resp.sendRedirect("/");
    }

    private ModelAndView loginFailed(){
        //resp.sendRedirect("/user/login_failed");
        return new ModelAndView(new JspView(REDIRECT +"/user/login_failed"));
    }
}