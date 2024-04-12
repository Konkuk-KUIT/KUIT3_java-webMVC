package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.AbstractController;
import core.mvc.view.JspView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController extends AbstractController {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {

//        req.setAttribute("questions", questionRepository.findAll());
//        JspView jspView= new JspView("/home.jsp");
        return jspView("/home.jsp").addModel("questions", questionRepository.findAll());
    }
}
