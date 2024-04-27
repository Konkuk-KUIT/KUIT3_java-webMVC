package jwp.controller.v3;

import core.db.MemoryQuestionRepository;
import core.mvc.v1.ControllerV1;
import core.mvc.view.ModelAndView;
import jwp.model.Question;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class HomeControllerV1 implements ControllerV1 {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public ModelAndView execute(Map<String, String> params) {
        log.info("HomeControllerV1");

        ModelAndView modelAndView = new ModelAndView("/v1/homeV1");
        List<Question> questions = questionRepository.findAll().stream().toList();
        modelAndView.getModel().put("questions", questions);
        return modelAndView;
    }
}