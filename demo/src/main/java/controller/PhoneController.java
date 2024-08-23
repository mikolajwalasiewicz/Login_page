package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import model.Phone;
import service.PhoneService;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @PostMapping
    public ResponseEntity<Phone> addPhone(@RequestBody Phone phone) {
        Phone savedPhone = phoneService.savePhone(phone);
        return ResponseEntity.ok(savedPhone);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phone> getPhoneById(@PathVariable Long id) {
        Optional<Phone> phone = phoneService.findPhoneById(id);
        return phone.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Phone>> getPhonesByUserId(@PathVariable Long userId) {
        List<Phone> phones = phoneService.findPhonesByUserId(userId);
        return ResponseEntity.ok(phones);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Phone> updatePhone(@PathVariable Long id, @RequestBody Phone phone) {
        Optional<Phone> updatedPhone = phoneService.updatePhone(id, phone);
        return updatedPhone.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhone(@PathVariable Long id) {
        phoneService.deletePhone(id);
        return ResponseEntity.noContent().build();
    }
}