package core.mvc;

import core.mvc.view.ModelAndView;
import core.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public interface Controller {
    String REDIRECT_PREFIX = "redirect:";

    ModelAndView execute(Map<String, String> params) throws IOException;

    // default method : 인터페이스에 있는 구현 메소드
    default void setSession(HttpSession session) {};
}