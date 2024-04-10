package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class UpdateFormController implements Controller{
    //음...post로 할까 get으로 해야 할까
    //setAttribute로 user자체를 받아왔잖아? 근데 object로 받아오니까 이걸 다시 갖다 붙여야 되는거니까 post

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        MemoryUserRepository repository = MemoryUserRepository.getInstance();

        String userId = req.getParameter("userId");
        String newPassword = req.getParameter("password");
        String newName = req.getParameter("name");
        String newEmail = req.getParameter("email");
        User updatUser = new User(userId, newPassword,newName, newEmail);

        repository.changeUserInfo(updatUser);

        return "redirect:/user/userList";
    }
}
