package com.pragma.powerup.infrastructure.out;

import com.pragma.powerup.domain.spi.IUserPassEncodePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class BCrypPasswordEncoderAdapter implements IUserPassEncodePort {
    private final PasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
