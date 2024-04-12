package jwp.controller.qna;

import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.ModelAndView;
import jwp.controller.AbstractController;
import jwp.controller.Controller;
import jwp.model.Answer;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowQuestionController extends AbstractController {
    private static final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    private static final MemoryAnswerRepository memoryAnswerRepository = MemoryAnswerRepository.getInstance();

    @Override
    public ModelAndView execute(HttpServletRequest req) {

        Long questionId = Long.parseLong(req.getParameter("questionId"));
        Question question = questionRepository.findQuestionById(questionId);
        List<Answer> answers = memoryAnswerRepository.findAnswersByQuestionId(questionId);

        req.setAttribute("question", question);
        req.setAttribute("answers", answers);
        ModelAndView mav = jspView("/qna/show.jsp");
        mav.addModel("question", question).addModel("answers", answers);
        return mav;
    }
}
