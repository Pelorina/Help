package ChoseYourHelp.Help.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Request {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
}
