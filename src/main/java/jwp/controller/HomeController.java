package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.view.JSPView;
import core.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController extends AbstractController {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("questions", questionRepository.findAll());
        return new JSPView("/home.jsp");
    }
}
