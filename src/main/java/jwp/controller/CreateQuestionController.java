package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.Controller;
import jwp.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateQuestionController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Question question = new Question(req.getParameter("author"),
                req.getParameter("title"),
                req.getParameter("contents"));

        MemoryQuestionRepository.getInstance().addQuestion(question);

        return "redirect:/";
    }
}
