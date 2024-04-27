package jwp.controller.v3.qna;

import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.v2.ControllerV2;
import jwp.model.Answer;
import jwp.model.Question;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class AddAnswerControllerV2 implements ControllerV2 {
    private final MemoryAnswerRepository answerRepository = MemoryAnswerRepository.getInstance();
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public String execute(Map<String, String> params, Map<String, Object> model) throws IOException {
        log.info("AddAnswerControllerV2");
        Answer answer = new Answer(Long.parseLong(params.get("questionId")),
                params.get("author"),
                params.get("contents"));
        Answer savedAnswer = answerRepository.insert(answer);

        Question question = questionRepository.findQuestionById(answer.getQuestionId());
        question.increaseCountOfAnswer();
        questionRepository.update(question);

        model.put("answer", savedAnswer);
        return "jsonView";
    }
}