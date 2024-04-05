package jwp.util;

import jwp.controller.Controller;
import jwp.controller.ListUserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class RequestMapperTest {
    private RequestMapper mapper = new RequestMapper();

    @Test
    void testRequestMapping(){
        String uri = "/user/list";
        Controller controller = mapper.requestMapping(uri);

        System.out.println(controller);

        assertTrue(controller instanceof ListUserController);
    }

}