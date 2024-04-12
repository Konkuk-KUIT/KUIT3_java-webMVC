package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.constants.JspPath;
import jwp.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserFormController extends AbstractController {

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("userId");

        ModelAndView mav = getJspView(new Request(Type.FORWARD, JspPath.USER_UPDATE_FORM));
        mav.addModel("user", MemoryUserRepository.getInstance().findUserById(userId));

        return mav;
    }

}
