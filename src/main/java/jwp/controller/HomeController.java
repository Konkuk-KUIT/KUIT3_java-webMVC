package jwp.controller;

import core.db.MemoryQuestionRepository;
import jwp.constants.JspPath;
import jwp.constants.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements Controller {

    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();

    @Override
    public Request execute(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("questions", questionRepository.findAll());
        return new Request(Type.FORWARD, JspPath.HOME);
    }

}
