package jwp.controller.qna.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import jwp.controller.Controller;
import jwp.model.Answer;
import jwp.model.Question;

import javax.imageio.IIOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddAnswerController implements Controller {

    private final MemoryAnswerRepository answerRepository = MemoryAnswerRepository.getInstance();
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();

    @Override
    public Request execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Answer answer = new Answer(Long.parseLong(req.getParameter("questionId")),
                req.getParameter("author"),
                req.getParameter("contents"));
        Answer savedAnswer = answerRepository.insert(answer);

        Question question = questionRepository.findQuestionById(answer.getQuestionId());
        question.increaseCountOfAnswer();
        questionRepository.update(question);

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(mapper.writeValueAsString(savedAnswer));

        return null;
    }

}
