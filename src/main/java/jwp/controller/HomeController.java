package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.JspView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements Controller {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {

        JspView view = new JspView("/home.jsp");
        ModelAndView mav = new ModelAndView(view);
        mav.addModel("questions", questionRepository.findAll());

        return mav;
    }
}
