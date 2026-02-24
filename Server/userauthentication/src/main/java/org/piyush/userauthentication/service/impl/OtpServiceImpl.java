package org.piyush.userauthentication.service.impl;

import org.piyush.userauthentication.entity.OtpToken;
import org.piyush.userauthentication.repository.OtpRepository;
import org.piyush.userauthentication.service.OtpService;
import org.piyush.userauthentication.service.PasswordService;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OtpServiceImpl implements OtpService {

    private final OtpRepository otpRepository;
    private final PasswordService passwordService;

    public OtpServiceImpl(OtpRepository otpRepository,
            PasswordService passwordService) {
        this.otpRepository = otpRepository;
        this.passwordService = passwordService;
    }

    @Override
    public String generateOtp(String email) {

        SecureRandom random = new SecureRandom();

        int otpInt = 100000 + random.nextInt(900000);

        String otp = String.valueOf(otpInt);

        String hashedOtp = passwordService.hash(otp);

        OtpToken token = new OtpToken(
                hashedOtp,
                LocalDateTime.now().plusMinutes(5),
                email);

        otpRepository.save(token);

        return otp;
    }

    @Override
    public boolean verifyOtp(String email, String otp) {

        Optional<OtpToken> optional = otpRepository.findByEmail(email);

        if (optional.isEmpty())
            return false;

        OtpToken token = optional.get();

        if (token.getExpiryTime().isBefore(LocalDateTime.now()))
            return false;

        return passwordService.verify(otp, token.getOtpHash());
    }
}
