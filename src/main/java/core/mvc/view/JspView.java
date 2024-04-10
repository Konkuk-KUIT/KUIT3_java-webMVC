package core.mvc.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;
import java.util.Map;

public class JspView implements view {
    private final String viewName;
    private static final String REDIRECT = "redirect:";

    public JspView(String JspName){
        this.viewName = JspName;
    }
    @Override
    public void render(Map<String,Object> model, HttpServletRequest req, HttpServletResponse resp)throws Exception{

        for (Map.Entry<String, Object> entry : model.entrySet()) {
            String attributeName = entry.getKey();
            Object attributeValue = entry.getValue();
            req.setAttribute(attributeName, attributeValue);
        }

        if(this.viewName.startsWith("redirect:")){
            String redirectURL = this.viewName.substring(REDIRECT.length());
            System.out.println("redirect URL : "+ redirectURL);
            resp.sendRedirect(redirectURL);
            return;
        }

        try {
            RequestDispatcher rd = req.getRequestDispatcher(this.viewName);
            System.out.println("forward Path : " + this.viewName);
            rd.forward(req, resp);
        }catch (Throwable e) {
            throw new ServletException(e.getMessage());
        }
    }


}
