package repository;

import model.Banned;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannedRepository extends JpaRepository<Banned, Long> {

    public void deleteByUserId(Long userId);

    public boolean existsByUserId(Long userId);
}
