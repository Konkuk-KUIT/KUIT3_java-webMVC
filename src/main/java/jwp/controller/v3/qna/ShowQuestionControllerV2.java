package jwp.controller.v3.qna;

import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.v2.ControllerV2;
import jwp.model.Answer;
import jwp.model.Question;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
public class ShowQuestionControllerV2 implements ControllerV2 {
    private static final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    private static final MemoryAnswerRepository memoryAnswerRepository = MemoryAnswerRepository.getInstance();

    @Override
    public String execute(Map<String, String> params, Map<String, Object> model) throws IOException {
        log.info("ShowQuestionControllerV2");
        Long questionId = Long.parseLong(params.get("questionId"));
        Question question = questionRepository.findQuestionById(questionId);
        List<Answer> answers = memoryAnswerRepository.findAnswersByQuestionId(questionId);

        model.put("question", question);
        model.put("answers", answers);
        return "/v2/qna/show";
    }
}
