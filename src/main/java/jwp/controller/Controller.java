package jwp.controller;

import core.constant.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static core.constant.Method.GET;
import static core.constant.Method.POST;

public interface Controller {

  String REDIRECT_PREFIX = "redirect:";

  default String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (request.getMethod().equals(GET.getKey())) {
      return doGet(request, response);
    }
    if (request.getMethod().equals(POST.getKey())) {
      return doPost(request, response);
    }

    return null;
  }

  String doPost(HttpServletRequest request, HttpServletResponse response) throws Exception;

  String doGet(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
