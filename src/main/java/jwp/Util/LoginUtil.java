package jwp.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUtil {


    public static boolean  isLogin(HttpSession userSession){
        if(userSession == null || userSession.getAttribute("user") == null ){
            return false;
        }
        return true;
    }

    public static boolean  isLogin(HttpServletRequest req){
        return isLogin(req.getSession());
    }

}
