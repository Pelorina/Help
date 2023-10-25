package ChoseYourHelp.Help.Hiree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequest {
    private Long userId;
    private String serviceOffered;
    private Double hourlyRate;
    private String availability;
    private String YearsOfExperience;
    private String profilePicture;
    private String phoneNumber;
}
