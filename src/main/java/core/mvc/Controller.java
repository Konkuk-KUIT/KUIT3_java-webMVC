package core.mvc;

import core.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 이제는 View를 반환하니깐 Controller 또한 View를 반환하도록 코드를 리팩토링하자
public interface Controller {
    // String이 아닌 View을 Return 하도록 변경
    static final String REDIRECT = "redirect:";
    View execute(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}