package jwp.controller.v2;

import core.db.MemoryQuestionRepository;
import core.mvc.v2.ControllerV2;
import core.mvc.view.ModelAndView;
import jwp.model.Question;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
public class HomeControllerV2 implements ControllerV2 {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public String execute(Map<String, String> params, Map<String, Object> model) throws IOException {
        log.info("HomeControllerV2");

        List<Question> questions = questionRepository.findAll().stream().toList();
        model.put("questions", questions);
        return "/v2/homeV2";
    }
}