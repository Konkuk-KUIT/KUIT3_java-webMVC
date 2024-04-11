package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.mvc.view.View;
import core.mvc.view.JspView;

public class HomeController implements Controller {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("questions", questionRepository.findAll());
//        return "/home.jsp";
        return new JspView("/home.jsp");
    }
}
