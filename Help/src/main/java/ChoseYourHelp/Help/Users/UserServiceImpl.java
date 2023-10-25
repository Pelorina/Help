package ChoseYourHelp.Help.Users;

import ChoseYourHelp.Help.Response.CustomResponse;
import ChoseYourHelp.Help.Utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public ResponseEntity<CustomResponse> signup(Request request) {
        boolean findByEmail = userRepo.existsByEmail(request.getEmail());
        if (findByEmail) {
            return ResponseEntity.badRequest().body(CustomResponse.builder()
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .responseMessage(ResponseUtil.USER_EXISTS_MESSAGE)
                    .build());
        }
        if(!request.getPassword().equals(request.getConfirmPassword())){
            return ResponseEntity.badRequest().body(CustomResponse.builder()
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .responseMessage(ResponseUtil.PASSWORD_INCORRECT_MESSAGE)
                    .build());
        }
        else{
            User user= User.builder()
                    .email(request.getEmail())
                    .username(request.getUsername())
                    .password(request.getPassword())
                    .confirmPassword(request.getConfirmPassword())
                    .build();
            User saved =userRepo.save(user);
        }
        return ResponseEntity.ok().body(CustomResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .responseMessage(ResponseUtil.SIGNUP_SUCCESSFUL)
                .build());

    }
}