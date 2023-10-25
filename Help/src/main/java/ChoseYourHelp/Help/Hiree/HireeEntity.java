package ChoseYourHelp.Help.Hiree;

import ChoseYourHelp.Help.Enum.UserType;
import ChoseYourHelp.Help.Users.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
@Getter
@Setter
public class HireeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birthdate; // Store birthdate instead of age
    private String gender;
    private String serviceOffered;
    private Double hourlyRate;
    private String availability;
    private String profilePicture;
    private String phoneNumber;
    private String yearsOfExperience; // Use camelCase for variable names
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToOne
    @JoinColumn(name = "hire")
    private User user;
}
