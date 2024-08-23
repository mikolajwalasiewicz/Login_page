package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import model.Banned;
import model.User;
import repository.BannedRepository;
import repository.UserRepository;

@Service
public class BannedService {

    @Autowired
    private BannedRepository bannedRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Banuje użytkownika na czas nieokreślony.
     *
     * @param userId identyfikator użytkownika do zbanowania
     * @param reason powód bana
     * @return obiekt Banned
     */
    public Optional<Banned> banUser(Long userId, String reason) {
        return userRepository.findById(userId).map((User user) -> {
            Banned banned = new Banned();
            banned.setUser(user);
            banned.setReason(reason);
            banned.setBannedAt(new Date());
            return bannedRepository.save(banned);
        });
    }

    /**
     * Sprawdza, czy użytkownik jest zbanowany.
     *
     * @param userId identyfikator użytkownika
     * @return true jeśli zbanowany, false w przeciwnym wypadku
     */
    public boolean isUserBanned(Long userId) {
        return bannedRepository.existsByUserId(userId);
    }

    /**
     * Usuwa bana z użytkownika.
     *
     * @param userId identyfikator użytkownika
     */
    public void unbanUser(Long userId) {
        bannedRepository.deleteByUserId(userId);
    }

    /**
     * Pobiera listę wszystkich zbanowanych użytkowników.
     *
     * @return lista obiektów Banned
     */
    public List<Banned> getAllBannedUsers() {
        return bannedRepository.findAll();
    }
}
