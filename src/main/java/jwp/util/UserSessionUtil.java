package jwp.util;

import javax.servlet.http.HttpSession;

public class UserSessionUtil {

    private static final String USER_SESSION_KEY = "userKey";

    public static void login(HttpSession session, String loginId) {
        session.setAttribute(USER_SESSION_KEY, loginId);
    }

    public static void logout(HttpSession session) {
        session.removeAttribute(USER_SESSION_KEY);
    }

    public static Boolean isLogin(HttpSession session) {
        return !(session.getAttribute(USER_SESSION_KEY) == null);
    }

}
