package jwp.controller.qna.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.view.JsonView;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import core.mvc.view.View;
import jwp.model.Answer;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddAnswerController extends AbstractController {
    private final MemoryAnswerRepository answerRepository = MemoryAnswerRepository.getInstance();
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Answer answer = new Answer(Long.parseLong(req.getParameter("questionId")),
                req.getParameter("author"),
                req.getParameter("contents"));
        Answer savedAnswer = answerRepository.insert(answer);

        Question question = questionRepository.findQuestionById(answer.getQuestionId());
        question.increaseCountOfAnswer();
        questionRepository.update(question);

        // 화면 다시 랜더링 하면 안되니깐 JsonView 반환
        ModelAndView mav = jsonView();

        return jsonView().addModel("answer", savedAnswer); //return this를 통한 chaining
    }
}
