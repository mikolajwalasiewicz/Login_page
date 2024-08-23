package repository;

import model.Phone;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    public List<Phone> findByUserId(Long userId);

    public model.Phone save(model.Phone phone);
}
