package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.model.Question;

import java.util.List;
import java.util.Map;

public class HomeController extends AbstractController {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public ModelAndView execute(Map<String, String> params) {
        List<Question> questions = questionRepository.findAll().stream().toList();
        return jspView("/home.jsp").addObject("questions",questions);
    }
}
