package core.mvc_framework;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet{
    private RequestMapper reqMapper;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Controller controller = reqMapper.getController(req);
        try {
            String result =controller.execute(req,resp);
            move(result, req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void init(){

        this.reqMapper = new RequestMapper();
    }
    private void move(String result,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(result.startsWith("redirect:")){
            resp.sendRedirect(result.substring("redirect:".length()));
            return;
        }
        RequestDispatcher rd = req.getRequestDispatcher(result);
        rd.forward(req, resp);
    }
}



