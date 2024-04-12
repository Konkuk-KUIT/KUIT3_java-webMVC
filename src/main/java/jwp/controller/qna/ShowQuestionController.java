package jwp.controller.qna;

import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.JspView;
import core.mvc.view.View;
import jwp.model.Answer;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowQuestionController extends AbstractController {
    private static final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    private static final MemoryAnswerRepository memoryAnswerRepository = MemoryAnswerRepository.getInstance();

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {

        Long questionId = Long.parseLong(req.getParameter("questionId"));
        Question question = questionRepository.findQuestionById(questionId);
        List<Answer> answers = memoryAnswerRepository.findAnswersByQuestionId(questionId);


        ModelAndView mv = jspModelAndView("/qna/show.jsp");
        mv.setAttribute("question", question).setAttribute("answers", answers);
        return mv;
    }
}
