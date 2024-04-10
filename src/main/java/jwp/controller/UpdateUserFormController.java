package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class UpdateUserFormController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        MemoryUserRepository repository = MemoryUserRepository.getInstance();

        String userId = req.getParameter("userId");
        User target = repository.findUserById(userId);

        if(target != null) {
            req.setAttribute("user", target);
            return "/user/updateForm.jsp";
        }
        return "redirect:/";
    }
}