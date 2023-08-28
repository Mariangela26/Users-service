package com.pragma.powerup.infrastructure.out;

import com.pragma.powerup.domain.spi.IToken;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.security.TokenUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class TokenAdapter implements IToken {
    @Override
    public String getBearerToken() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
    }

    @Override
    public String getEmail(String token) {
        if(token==(null)) throw  new NoDataFoundException();
        return TokenUtils.getEmail(token.replace("Bearer ",""));
    }

    @Override
    public Long getUserAutenticateId(String token) {
        if(token==(null)) throw  new NoDataFoundException();
        return TokenUtils.getUserAutenticateId(token.replace("Bearer ",""));
    }

    @Override
    public String getUserAutenticateRol(String token) {
        if(token==(null)) throw  new NoDataFoundException();
        return TokenUtils.getUserAutenticateRol(token.replace("Bearer ",""));
    }
}

