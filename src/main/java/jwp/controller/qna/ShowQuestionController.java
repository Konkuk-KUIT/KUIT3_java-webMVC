package jwp.controller.qna;

import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.JspView;
import jwp.model.Answer;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ShowQuestionController extends AbstractController {
    private static final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    private static final MemoryAnswerRepository memoryAnswerRepository = MemoryAnswerRepository.getInstance();

    @Override
    public ModelAndView execute(Map<String, String> params) {

        Long questionId = Long.parseLong(params.get("questionId"));
        Question question = questionRepository.findQuestionById(questionId);
        List<Answer> answers = memoryAnswerRepository.findAnswersByQuestionId(questionId);

        return JspView("/qna/show.jsp").addModel("question", question).addModel("answers", answers);
    }
}
