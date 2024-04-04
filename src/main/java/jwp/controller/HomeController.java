package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/")
public class HomeController implements Controller{
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
//        rd.forward(req,resp);
//    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "home.jsp";
    }
}
