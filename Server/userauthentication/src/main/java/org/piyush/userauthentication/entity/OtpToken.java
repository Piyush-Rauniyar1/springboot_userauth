package org.piyush.userauthentication.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OtpToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String otpHash;

    private LocalDateTime expiryTime;

    private String email;

    public OtpToken() {
    }

    public OtpToken(String otpHash, LocalDateTime expiryTime, String email) {
        this.otpHash = otpHash;
        this.expiryTime = expiryTime;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getOtpHash() {
        return otpHash;
    }

    public void setOtpHash(String otpHash) {
        this.otpHash = otpHash;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
