package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import java.util.Map;

public class HomeController extends AbstractController {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();

    @Override
    public ModelAndView execute(Map<String, String> params) {

        return JspView("/home.jsp").addModel("questions", questionRepository.findAll());
    }
}
