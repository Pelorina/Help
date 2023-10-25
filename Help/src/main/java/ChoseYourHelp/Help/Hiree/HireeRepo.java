package ChoseYourHelp.Help.Hiree;

import ChoseYourHelp.Help.Enum.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HireeRepo extends JpaRepository<HireeEntity,Long> {
    List<HireeEntity> findByServiceOffered(String category);
    boolean existsByServiceOffered(String serviceOffered);
    boolean  existsByPhoneNumber(String phoneNumber);
    HireeEntity findByPhoneNumber(String phoneNumber);
    HireeEntity findByEmail(String email);

}
