package core.mvc;

import core.mvc.view.JsonView;
import core.mvc.view.JspView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public abstract class AbstractController implements Controller{
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            return customExecute(req, resp);
        } catch (Exception e) {
            throw new IOException("컨트롤러 실행 실패", e);
        }
    }

    protected abstract ModelAndView customExecute(HttpServletRequest req, HttpServletResponse resp) throws Exception;

    //일단 new ModelAndView(new JspView(urlPath))를 반복해서 쓰는걸 막는 거기 때문에 이건 맞다. 근데 jsonView는 도대체 뭐냐 진짜
    protected ModelAndView jspView(String urlPath) {
        return new ModelAndView(new JspView(urlPath));
    }

    protected ModelAndView jsonView() {
        return new ModelAndView(new JsonView());
    }
}
