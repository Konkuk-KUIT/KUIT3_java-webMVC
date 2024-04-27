package jwp.controller.v3.qna;

import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.v1.ControllerV1;
import core.mvc.view.ModelAndView;
import jwp.model.Answer;
import jwp.model.Question;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class ShowQuestionControllerV1 implements ControllerV1 {
    private static final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    private static final MemoryAnswerRepository memoryAnswerRepository = MemoryAnswerRepository.getInstance();

    @Override
    public ModelAndView execute(Map<String, String> params) {
        log.info("ShowQuestionControllerV1");
        Long questionId = Long.parseLong(params.get("questionId"));
        Question question = questionRepository.findQuestionById(questionId);
        List<Answer> answers = memoryAnswerRepository.findAnswersByQuestionId(questionId);

        ModelAndView modelAndView = new ModelAndView("/v1/qna/show");
        modelAndView.getModel().put("question", question);
        modelAndView.getModel().put("answers", answers);
        return modelAndView;
    }
}
