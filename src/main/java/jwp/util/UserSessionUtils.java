package jwp.util;

import jwp.model.User;

import javax.servlet.http.HttpSession;

public class UserSessionUtils {
    public static final String USER_SESSION_KEY = "user";

    public static User getUserFromSession(HttpSession session) {
        Object user = session.getAttribute(USER_SESSION_KEY);
        if (user == null) return null;
        return (User) user;
    }

    public static boolean isLogined(HttpSession session) {
        return getUserFromSession(session) != null;
    }
}
