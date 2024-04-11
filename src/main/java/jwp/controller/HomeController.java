package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;

import java.io.IOException;
import java.util.Map;

public class HomeController extends AbstractController {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public ModelAndView execute(Map<String, String> paraMap) throws IOException {
        ModelAndView mav = jspView("./home.jsp");
        mav.addModel("questions", questionRepository.findAll());
        return mav;
    }
}
