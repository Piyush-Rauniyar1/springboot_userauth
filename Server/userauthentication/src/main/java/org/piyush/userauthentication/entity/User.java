package org.piyush.userauthentication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "users", indexes = {
                @Index(name = "idx_users_email", columnList = "email")
})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
        @Id
        @GeneratedValue
        private UUID id;

        @Column(nullable = false, unique = true)
        private String email;

        @Column
        private String username;

        @Column
        private String phone;

        @Column(name = "password_hash", nullable = false)
        private String passwordHash;

        @Column(nullable = false)
        private String role;

        @Builder.Default
        @Column(name = "is_verified", nullable = false)
        private boolean isVerified = false;

        @Builder.Default
        @Column(name = "failed_attempts", nullable = false)
        private int failedAttempts = 0;

        @Builder.Default
        @Column(name = "account_locked", nullable = false)
        private boolean accountLocked = false;

}
