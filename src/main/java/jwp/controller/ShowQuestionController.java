package jwp.controller;

import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.Controller;
import jwp.model.Answer;
import jwp.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowQuestionController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int questionId = Integer.parseInt(req.getParameter("questionId"));
        Question question = MemoryQuestionRepository.getInstance().findQuestionById(questionId);
        List<Answer> answerList = MemoryAnswerRepository.getInstance().findAnswersByQuestionId(questionId);

        if (question != null) {
            req.setAttribute("question", question);
            req.setAttribute("answerList", answerList);
            return "/qna/show.jsp";
        }

        return "redirect:/";
    }
}
