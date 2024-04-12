package jwp.controller.qna;

import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import jwp.controller.Controller;
import jwp.controller.HTTPController;
import jwp.model.Answer;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ShowQuestionController extends HTTPController {
    private static final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    private static final MemoryAnswerRepository memoryAnswerRepository = MemoryAnswerRepository.getInstance();

    @Override
    public ModelAndView execute(HttpServletRequest req) {

        Long questionId = Long.parseLong(req.getParameter("questionId"));
        Question question = questionRepository.findQuestionById(questionId);
        List<Answer> answers = memoryAnswerRepository.findAnswersByQuestionId(questionId);

        //req.setAttribute("question", question);
        //req.setAttribute();
        ModelAndView View = jspView("/qna/show.jsp");

        return View
                .addModel("question", question)
                .addModel("answers", answers);

    }
}
