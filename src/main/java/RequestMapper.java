import jwp.controller.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Controller mapping
public class RequestMapper {
    HomeController homeController;
    CreateUserController createUserController;
    ListUserController listUserController;
    LoginController loginController;
    LogoutController logoutController;
    UpdateUserFormController updateUserFormController;
    UpdateUserController updateUserController;

    public RequestMapper() {
        homeController = new HomeController();
        createUserController = new CreateUserController();
        listUserController = new ListUserController();
        loginController = new LoginController();
        logoutController = new LogoutController();
        updateUserController = new UpdateUserController();
        updateUserFormController = new UpdateUserFormController();
    }
    public String MappingController(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String uri = req.getRequestURI();
        String view = null;
        if (uri.endsWith(".jsp"))
            return uri;
        switch (uri) {
            case "/":
                view = homeController.execute(req,resp);
                break;
            case "/user/signup":
                view = createUserController.execute(req, resp);
                break;
            case "/user/login":
                view = loginController.execute(req, resp);
                break;
            case "/user/logout":
                view = logoutController.execute(req, resp);
                break;
            case "/user/userList":
                view = listUserController.execute(req, resp);
                break;
            case "/user/update":
                view = updateUserController.execute(req, resp);
                break;
            case "/user/updateForm":
                view = updateUserFormController.execute(req, resp);
                break;
        }
        return view;
    }
}
