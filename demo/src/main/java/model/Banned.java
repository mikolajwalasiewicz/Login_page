package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "banned")
public class Banned {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private char isBanned;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    private Date bannedAt;
    private String reason;

    // Getters and setters
    public void setBannedAt(Date date) {
        this.bannedAt = date;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setUser(model.User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public char getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(char isBanned) {
        this.isBanned = isBanned;
    }

    public User getUser() {
        return user;
    }

}
