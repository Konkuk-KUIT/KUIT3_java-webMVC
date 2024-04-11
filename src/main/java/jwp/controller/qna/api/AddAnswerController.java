package jwp.controller.qna.api;

import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.ModelAndView;
import core.mvc.AbstractController;
import jwp.model.Answer;
import jwp.model.Question;

import java.io.IOException;
import java.util.Map;

public class AddAnswerController extends AbstractController {
    private final MemoryAnswerRepository answerRepository = MemoryAnswerRepository.getInstance();
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public ModelAndView execute(Map<String, String> paraMap) throws IOException {
        Answer answer = new Answer(Long.parseLong(paraMap.get("questionId")),
                paraMap.get("author"),
                paraMap.get("contents"));
        Answer savedAnswer = answerRepository.insert(answer);

        Question question = questionRepository.findQuestionById(answer.getQuestionId());
        question.increaseCountOfAnswer();
        questionRepository.update(question);

        ModelAndView mav = jsonView();
        mav.addModel("answer", savedAnswer);

        return jsonView();
    }
}
