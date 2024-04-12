package core.mvc.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class JspView implements View{

    private final String viewName;
    private static final String REDIRECT_PREFIX = "redirect:";

    public JspView(String viewName) {
        this.viewName = viewName;
    }
    @Override
    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //이거는 jsp로 반환해줘야 하는 애들 그니까 기존의 비동기 통신 적용 전에 그냥 간단한 페이지 반환할 때 쓰는 애들
        model.forEach((key, value) -> req.setAttribute(key, value));
        if (viewName.startsWith(REDIRECT_PREFIX)) {
            resp.sendRedirect(viewName.substring(REDIRECT_PREFIX.length()));
            return;
        }
        RequestDispatcher rd = req.getRequestDispatcher(viewName);
        rd.forward(req, resp);
    }
}
