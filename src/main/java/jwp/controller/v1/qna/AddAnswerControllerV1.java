package jwp.controller.v1.qna;

import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.v1.ControllerV1;
import core.mvc.view.ModelAndView;
import jwp.model.Answer;
import jwp.model.Question;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class AddAnswerControllerV1 implements ControllerV1 {
    private final MemoryAnswerRepository answerRepository = MemoryAnswerRepository.getInstance();
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public ModelAndView execute(Map<String, String> params) throws IOException {
        log.info("AddAnswerControllerV1");
        Answer answer = new Answer(Long.parseLong(params.get("questionId")),
                params.get("author"),
                params.get("contents"));
        Answer savedAnswer = answerRepository.insert(answer);

        Question question = questionRepository.findQuestionById(answer.getQuestionId());
        question.increaseCountOfAnswer();
        questionRepository.update(question);

        ModelAndView modelAndView = new ModelAndView("jsonView");
        modelAndView.getModel().put("answer", savedAnswer);
        return modelAndView;
    }
}