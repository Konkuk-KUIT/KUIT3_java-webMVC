package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.Controller;
import jwp.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowQuestionController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Question question = MemoryQuestionRepository.getInstance().findQuestionById(req.getParameter("questionId"));

        if (question != null) {
            req.setAttribute("question", question);
            return "/qna/show.jsp";
        }

        return "redirect:/";
    }
}
