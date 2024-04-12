package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.view.AbstractController;
import core.mvc.view.ModelAndView;

import java.io.IOException;
import java.util.Map;

public class HomeController extends AbstractController {
  private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();

  @Override
  public ModelAndView execute(Map<String, String> params) throws IOException {
    return jspView("/home.jsp")
      .addModel("questions", questionRepository.findAll());
  }
}
