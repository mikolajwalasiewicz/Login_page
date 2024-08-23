package service;

import repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import model.Email;
import org.springframework.stereotype.Service;
import repository.EmailRepository;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Zapisuje nowy adres email powiązany z użytkownikiem.
     *
     * @param email obiekt Email do zapisania
     * @return zapisany obiekt Email
     */
    public Email saveEmail(Email email) {
        return emailRepository.save(email);
    }

    /**
     * Pobiera adres email na podstawie jego ID.
     *
     * @param id identyfikator emaila
     * @return Optional zawierający email lub pusty, jeśli nie znaleziono
     */
    public Optional<Email> findEmailById(Long id) {
        return emailRepository.findById(id);
    }

    /**
     * Pobiera wszystkie adresy email powiązane z danym użytkownikiem.
     *
     * @param userId identyfikator użytkownika
     * @return lista adresów email
     */
    public List<Email> findEmailsByUserId(Long userId) {
        return emailRepository.findByUserId(userId);
    }


    /**
     * Usuwa adres email na podstawie jego ID.
     *
     * @param id identyfikator emaila do usunięcia
     */
    public void deleteEmail(Long id) {
        emailRepository.deleteById(id);
    }

    public Optional<Email> updateEmail(Long id, Email email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
