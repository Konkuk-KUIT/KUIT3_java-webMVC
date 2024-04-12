package jwp.controller.qna;

import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import core.mvc.view.View;
import jwp.controller.AbstractController;
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

        System.out.println("showQuestionCon : " + question);

        ModelAndView mav = jspView("/qna/show.jsp");
        mav.addModel("question", question);  // model에 담을 수 있을까? 담으면 어떻게 사용해야할까?
        mav.addModel("answers", answers);
        return mav;
    }
}
