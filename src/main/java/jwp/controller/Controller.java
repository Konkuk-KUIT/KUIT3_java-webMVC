package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller{
    static final String REDIRECT = "redirect:";
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}