package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Metoda do zapisywania użytkownika w bazie danych
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Kodowanie hasła
        return userRepository.save(user);
    }

    // Metoda do znajdowania użytkownika po jego ID
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    // Metoda do sprawdzenia, czy użytkownik o danej nazwie istnieje
    public boolean userExists(String username) {
        return userRepository.findByName(username) != null;
    }

    // Metoda do pobierania wszystkich użytkowników
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Metoda do aktualizacji danych użytkownika
    public Optional<User> updateUser(Long id, User user) {
        return userRepository.findById(id).map((User existingUser) -> {
            existingUser.setName(user.getName());
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(existingUser);
        });
    }

    // Metoda do usuwania użytkownika
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
