package jwp.controller.qna.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import jwp.model.Answer;
import jwp.model.Question;
import org.apache.tomcat.util.log.UserDataHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddAnswerController extends AbstractController {
    private final MemoryAnswerRepository answerRepository = MemoryAnswerRepository.getInstance();
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    protected ModelAndView customExecute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Answer answer = new Answer(Long.parseLong(req.getParameter("questionId")),
                req.getParameter("author"),
                req.getParameter("contents"));
        Answer savedAnswer = answerRepository.insert(answer);

        Question question = questionRepository.findQuestionById(answer.getQuestionId());
        question.increaseCountOfAnswer();
        questionRepository.update(question);

        // Jackson 라이브러리 활용
//        ObjectMapper mapper = new ObjectMapper();
//        //근데 이부분이 jsonView의 render하고 똑같음. 왠지 그냥 JsonView로 조져버려도 될거 같은데?
//        resp.setContentType("application/json;charset=UTF-8");
//        PrintWriter out = resp.getWriter();
//        //데이터를 json으로 바꿔주는 작업
//        out.print(mapper.writeValueAsString(savedAnswer));

        return jsonView().addModel("answer", savedAnswer);
    }
}
