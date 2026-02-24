package org.piyush.userauthentication.service;

public interface PasswordService {
    String hash(String rawPassword);

    boolean verify(String rawPassword, String hashedPassword);
}
