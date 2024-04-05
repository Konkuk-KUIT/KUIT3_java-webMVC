package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements Controller {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("questions", questionRepository.findAll());
        return "/home.jsp";
    }
}
