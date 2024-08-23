package repository;

import java.util.List;
import model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {

    public List<Email> findByUserId(Long userId);
}
