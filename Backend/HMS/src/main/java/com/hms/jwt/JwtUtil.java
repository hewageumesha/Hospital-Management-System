package com.hms.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil{
    private static final Long JWT_TOKEN_VALIDITY = 5 * 60 * 60L;
    private static final String SECRET="2540a95c7cb5379d92aa8ab47599b5feb963b430b543b0de43b3b55a1b5c83ca5cd1b0eec4809a67bcc365d5f0e9e5e4642f681d093663406ffab01a39959194";

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        CustomUserDetails user = (CustomUserDetails) userDetails;
        claims.put("id", user.getId());
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());
        claims.put("name", user.getName());
        return doGenerateToken(claims, userDetails.getUsername());
    }

    public String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000)).signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }
}
