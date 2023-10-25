package ChoseYourHelp.Help.Users;

import ChoseYourHelp.Help.Response.CustomResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<CustomResponse> signup(Request request);
}
