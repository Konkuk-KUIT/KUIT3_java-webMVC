package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class HomeController extends AbstractController {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();

    @Override
    public ModelAndView execute(Map<String, String> paramMap) {

        ModelAndView mav = jspView("/home.jsp");
        mav.addModel("questions", questionRepository.findAll());
        return mav;
    }
}
