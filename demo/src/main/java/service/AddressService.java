package service;

import model.Address;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import repository.AddressRepository;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    // Metoda do zapisywania adresu w bazie danych
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    // Metoda do znajdowania adresu po jego ID
    public Optional<Address> findAddressById(Long id) {
        return addressRepository.findById(id);
    }

    // Dodaj inne metody logiki biznesowej, np. aktualizowanie adresu, usuwanie adresu itp.


    public List<model.Address> findAddressesByUserId(Long userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Optional<model.Address> updateAddress(Long id, model.Address address) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void deleteAddress(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
