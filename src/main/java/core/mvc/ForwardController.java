package core.mvc;

import core.mvc.view.AbstractController;
import core.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ForwardController extends AbstractController {
  private String forwardUrl;

  public ForwardController(String forwardUrl) {
    this.forwardUrl = forwardUrl;
    if (forwardUrl == null) {
      throw new NullPointerException("forwardUrl is null. 이동할 URL을 입력하세요.");
    }
  }

  @Override
  public ModelAndView execute(Map<String, String> params) throws IOException {
    return jspView(forwardUrl);
  }
}