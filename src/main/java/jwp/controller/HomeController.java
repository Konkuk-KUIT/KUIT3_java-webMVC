package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.Controller;
import core.mvc.view.JSPView;
import core.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController extends AbstractController {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        ModelAndView model = JSPView("/home.jsp");
        model.addModel("questions", questionRepository.findAll());
        //req.setAttribute("questions", questionRepository.findAll());
        return model;
        //return new ModelAndView(new JSPView("/home.jsp")를 Abstract JSPView()를 구현하므로써 refactoring
    }
}
