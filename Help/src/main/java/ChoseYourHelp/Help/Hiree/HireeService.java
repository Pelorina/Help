package ChoseYourHelp.Help.Hiree;

import ChoseYourHelp.Help.Enum.Category;
import ChoseYourHelp.Help.Response.CustomResponse;
import ChoseYourHelp.Help.Users.Request;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HireeService {
    public ResponseEntity<CustomResponse> signupHiree(HireeRequest request);

    List<HireeEntity> findByCategory(String serviceOffered);

    ResponseEntity<CustomResponse> update(UpdateRequest updateRequest);

    ResponseEntity<CustomResponse> resetPassword(Request request);
}