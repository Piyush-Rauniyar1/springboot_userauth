package org.piyush.userauthentication.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PasswordServiceTest {

    @Autowired
    private PasswordService passwordService;

    @Test
    void testPasswordHashing() {
        String rawPassword = "TestPassword123";

        String hashed = passwordService.hash(rawPassword);

        assertNotNull(hashed);
        assertNotEquals(rawPassword, hashed);
        assertTrue(passwordService.verify(rawPassword, hashed));
    }
}
