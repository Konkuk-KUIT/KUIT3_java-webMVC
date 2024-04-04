package jwp;

import jwp.model.User;

import javax.servlet.http.HttpSession;

public class UserSession {
    public static User getUserSession(HttpSession session){
        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");
        if (user != null) {
            User user = (User) value;
        }
        return null;
    }
    public static boolean logined(HttpSession session){
        if (!(getUserSession(session) = false)) {
            return getUserSession(session);
        }
        return null;

    }
}
