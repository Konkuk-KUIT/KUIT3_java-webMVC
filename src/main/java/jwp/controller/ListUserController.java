package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.constants.JspPath;
import jwp.constants.URL;
import jwp.util.UserSessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ListUserController implements Controller {

    @Override
    public Request execute(HttpServletRequest req, HttpServletResponse resp) {
        if(!UserSessionUtil.isLogin(req.getSession())) {
            return new Request(Type.REDIRECT, URL.USER_LOGIN);
        }

        req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
        return new Request(Type.FORWARD, JspPath.USER_LIST);
    }

}
