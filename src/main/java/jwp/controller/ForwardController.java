package jwp.controller;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller {

  private final String fileName;

  private ForwardController(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public String doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return null;
  }

  @Override
  public String doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return fileName;
  }

  public static ForwardController of(String uri) {
    if (!StringUtils.hasText(uri)) {
      throw new RuntimeException("fileName 이 유효하지 않습니다.");
    }
    return new ForwardController(uri);
  }
}
