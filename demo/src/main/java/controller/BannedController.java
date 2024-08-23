package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import model.Banned;
import service.BannedService;

@RestController
@RequestMapping("/api/banned")
public class BannedController {

    @Autowired
    private BannedService bannedService;

    @PostMapping("/ban/{userId}")
    public ResponseEntity<Banned> banUser(@PathVariable Long userId, @RequestBody String reason) {
        return bannedService.banUser(userId, reason)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/isBanned/{userId}")
    public ResponseEntity<Boolean> isUserBanned(@PathVariable Long userId) {
        boolean isBanned = bannedService.isUserBanned(userId);
        return ResponseEntity.ok(isBanned);
    }

    @DeleteMapping("/unban/{userId}")
    public ResponseEntity<Void> unbanUser(@PathVariable Long userId) {
        bannedService.unbanUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Banned>> getAllBannedUsers() {
        List<Banned> bannedUsers = bannedService.getAllBannedUsers();
        return ResponseEntity.ok(bannedUsers);
    }
}