package ChoseYourHelp.Help.Hiree;

import ChoseYourHelp.Help.Enum.Category;
import ChoseYourHelp.Help.Enum.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HireeRequest {
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String gender;
    private String serviceOffered;
    private Double hourlyRate;
    private String availability;
    private String profilePicture;
    private String phoneNumber;
    private String yearsOfExperience;
    private UserType userType;

}
