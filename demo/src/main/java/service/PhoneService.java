package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import model.Phone;
import repository.PhoneRepository;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    /**
     * Zapisuje nowy numer telefonu powiązany z użytkownikiem.
     *
     * @param phone obiekt Phone do zapisania
     * @return zapisany obiekt Phone
     */
    public Phone savePhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    /**
     * Pobiera numer telefonu na podstawie jego ID.
     *
     * @param id identyfikator telefonu
     * @return Optional zawierający telefon lub pusty, jeśli nie znaleziono
     */
    public Optional<Phone> findPhoneById(Long id) {
        return phoneRepository.findById(id);
    }

    /**
     * Pobiera wszystkie numery telefonów powiązane z danym użytkownikiem.
     *
     * @param userId identyfikator użytkownika
     * @return lista numerów telefonów
     */
    public List<Phone> findPhonesByUserId(Long userId) {
        return phoneRepository.findByUserId(userId);
    }

    /**
     * Usuwa numer telefonu na podstawie jego ID.
     *
     * @param id identyfikator telefonu do usunięcia
     */
    public void deletePhone(Long id) {
        phoneRepository.deleteById(id);
    }

    public Optional<Phone> updatePhone(Long id, Phone phone) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}