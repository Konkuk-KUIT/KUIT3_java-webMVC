package jwp.controller;

import core.db.MemoryQuestionRepository;
import jwp.constants.JspPath;
import jwp.constants.URL;
import jwp.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController extends AbstractController {

    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        ModelAndView mav = getJspView(new Request(Type.FORWARD, JspPath.HOME));
        mav.addModel("questions", questionRepository.findAll());
        return mav;
    }

}
