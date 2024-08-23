package repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // Metoda do znajdowania użytkownika po nazwie
    User findByName(String name);
}
