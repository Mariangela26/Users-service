package com.pragma.powerup.domain.spi;

public interface IToken {
    String getBearerToken();

    String getEmail(String token);

    Long getUserAutenticateId(String token);

    String getUserAutenticateRol(String token);
}
