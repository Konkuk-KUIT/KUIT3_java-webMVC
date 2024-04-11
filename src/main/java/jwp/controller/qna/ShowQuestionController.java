package jwp.controller.qna;

import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.ModelAndView;
import core.mvc.AbstractController;
import jwp.model.Answer;
import jwp.model.Question;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ShowQuestionController extends AbstractController {
    private static final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    private static final MemoryAnswerRepository memoryAnswerRepository = MemoryAnswerRepository.getInstance();

    @Override
    public ModelAndView execute(Map<String, String> paraMap) throws IOException {
        Long questionId = Long.parseLong(paraMap.get("questionId"));
        Question question = questionRepository.findQuestionById(questionId);
        List<Answer> answers = memoryAnswerRepository.findAnswersByQuestionId(questionId);

        ModelAndView mav = jspView("/qna/show.jsp");
        mav.addModel("question", question);
        mav.addModel("answers", answers);
        return mav;
    }
}
