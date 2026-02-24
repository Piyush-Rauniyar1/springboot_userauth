package org.piyush.userauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.piyush.userauthentication.entity.OtpToken;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<OtpToken, Long> {

    Optional<OtpToken> findByEmail(String email);

}
