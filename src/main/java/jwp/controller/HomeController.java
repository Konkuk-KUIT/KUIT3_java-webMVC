package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.view.JsonView;
import core.view.JspView;
import core.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements AbstractController {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("questions", questionRepository.findAll());
        return jspView("./home.jsp");
    }

    @Override
    public ModelAndView jspView(String url) {
        return new ModelAndView(new JspView(url));
    }

    public ModelAndView jsonView() {
        return new ModelAndView(new JsonView());
    }
}
