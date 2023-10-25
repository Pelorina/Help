package ChoseYourHelp.Help.Hiree;

import ChoseYourHelp.Help.Enum.UserType;
import ChoseYourHelp.Help.Extra.AgeRestriction;
import ChoseYourHelp.Help.Response.CustomResponse;
import ChoseYourHelp.Help.Users.Request;
import ChoseYourHelp.Help.Users.User;
import ChoseYourHelp.Help.Users.UserRepo;
import ChoseYourHelp.Help.Utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HireeServiceImpl implements HireeService {
    private final HireeRepo hireeRepo;
    private final UserRepo userRepo;

    public HireeServiceImpl(HireeRepo hireeRepo, UserRepo userRepo) {
        this.hireeRepo = hireeRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ResponseEntity<CustomResponse> signupHiree(HireeRequest request) {
        HireeEntity createhiree= HireeEntity.builder()
                .birthdate(AgeRestriction.validateAge(request.getBirthdate()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .availability(request.getAvailability())
                .gender(request.getGender())
                .profilePicture(request.getProfilePicture())
                .serviceOffered(request.getServiceOffered())
                .phoneNumber(request.getPhoneNumber())
                .yearsOfExperience(request.getYearsOfExperience())
                .hourlyRate(request.getHourlyRate())
                .userType(UserType.ROLE_HIREE)
                .build();
        HireeEntity saveHiree=hireeRepo.save(createhiree);
        return ResponseEntity.ok(CustomResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .responseMessage(ResponseUtil.SIGNUP_SUCCESSFUL)
                .build());
    }

    @Override
    public List<HireeEntity> findByCategory(String serviceOffered) {
//        boolean isExists= hireeRepo.existsByCategory(serviceOffered);
//        if(!isExists){
//
//        }
        return hireeRepo.findByServiceOffered(serviceOffered);
        }


// After implementing jwt come back and autopopulate the  phonenumber from the securitycontext.
    @Override
    public ResponseEntity<CustomResponse> update(UpdateRequest updateRequest) {
        // Fetch existing HireeEntity by phone number
        HireeEntity hireeEntity = hireeRepo.findByPhoneNumber(updateRequest.getPhoneNumber());

        if (hireeEntity == null) {
            // If no entity found with the given phone number, return bad request response
            return ResponseEntity.badRequest().body(CustomResponse.builder()
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .responseMessage("Hiree not found with the provided phone number.")
                    .build());
        }

        // Update fields of the existing entity with values from UpdateRequest
        hireeEntity.setHourlyRate(updateRequest.getHourlyRate());
        hireeEntity.setAvailability(updateRequest.getAvailability());
        hireeEntity.setServiceOffered(updateRequest.getServiceOffered());
        hireeEntity.setProfilePicture(updateRequest.getProfilePicture());
        hireeEntity.setYearsOfExperience(updateRequest.getYearsOfExperience());

        // Save the updated entity back to the database
        HireeEntity updatedHiree = hireeRepo.save(hireeEntity);

        return ResponseEntity.ok().body(CustomResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .responseMessage(ResponseUtil.PROFILE_UPDATE)
                .build());
    }
    @Override
    public ResponseEntity<CustomResponse> resetPassword(Request request) {
        User findByEmail=userRepo.findByEmail(request.getEmail());
        if(findByEmail==null){
            return  ResponseEntity.badRequest().body(CustomResponse.builder()
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .responseMessage("Invalid email")
                    .build());
        }
        if(!request.getPassword().equals(request.getConfirmPassword())){
            return ResponseEntity.badRequest().body(CustomResponse.builder()
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .responseMessage(ResponseUtil.PASSWORD_INCORRECT_MESSAGE)
                    .build());

        }
        findByEmail.setPassword(request.getPassword());
        findByEmail.setConfirmPassword(request.getConfirmPassword());
        userRepo.save(findByEmail);
        return ResponseEntity.ok().body(CustomResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .responseMessage(ResponseUtil.PASSWORD_UPDATED)
                .build());

    }


}





