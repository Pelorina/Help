package ChoseYourHelp.Help.Users;


import ChoseYourHelp.Help.Hiree.HireeEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    @OneToOne
    @JoinColumn(name = "user")
    private HireeEntity hire;

}

