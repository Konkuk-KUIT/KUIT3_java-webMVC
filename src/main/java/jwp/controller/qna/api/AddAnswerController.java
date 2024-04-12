package jwp.controller.qna.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.JsonView;
import core.mvc.view.JspView;
import jwp.model.Answer;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class AddAnswerController extends AbstractController {
    private final MemoryAnswerRepository answerRepository = MemoryAnswerRepository.getInstance();
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public ModelAndView execute(Map<String, String> params) throws IOException {
        Answer answer = new Answer(Long.parseLong(params.get("questionId")),
                params.get("author"),
                params.get("contents"));
        Answer savedAnswer = answerRepository.insert(answer);

        Question question = questionRepository.findQuestionById(answer.getQuestionId());
        question.increaseCountOfAnswer();
        questionRepository.update(question);

        return JsonView().addModel("questionId", savedAnswer.getQuestionId())
                .addModel("author", savedAnswer.getAuthor())
                .addModel("contents", savedAnswer.getContents())
                .addModel("answerId", savedAnswer.getAnswerId())
                .addModel("createdDate", savedAnswer.getCreatedDate());
        //return JsonView().addModel("answer",savedAnswer);
    }
}