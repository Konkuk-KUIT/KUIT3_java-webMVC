package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

  String REDIRECT_PREFIX = "redirect:";

  default String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (request.getMethod().equals("GET")) {
      return doGet(request, response);
    }
    if (request.getMethod().equals("POST")) {
      return doPost(request, response);
    }

    return null;
  }

  String doPost(HttpServletRequest request, HttpServletResponse response) throws Exception;

  String doGet(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
