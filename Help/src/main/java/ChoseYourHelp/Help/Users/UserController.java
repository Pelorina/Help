package ChoseYourHelp.Help.Users;

import ChoseYourHelp.Help.Hiree.HireeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final HireeService hireeService;

    public UserController(UserService userService, HireeService hireeService) {
        this.userService = userService;
        this.hireeService = hireeService;
    }
}
