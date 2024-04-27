package jwp.controller.v3.user;

import core.db.MemoryUserRepository;
import core.mvc.v1.ControllerV1;
import core.mvc.view.ModelAndView;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class ListUserControllerV1 implements ControllerV1 {
    private final MemoryUserRepository memoryUserRepository = MemoryUserRepository.getInstance();
    private boolean isLoggedIn = false;

    @Override
    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    @Override
    public ModelAndView execute(Map<String, String> params){
        log.info("ListUserControllerV1");

        if (isLoggedIn) {
            ModelAndView modelAndView = new ModelAndView("/v1/user/list");
            modelAndView.getModel().put("users", memoryUserRepository.findAll());
            return modelAndView;
        }
        return new ModelAndView(REDIRECT+"/v1/user/loginForm");
    }
}
