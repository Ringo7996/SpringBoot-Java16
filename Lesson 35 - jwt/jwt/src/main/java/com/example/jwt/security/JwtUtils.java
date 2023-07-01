package com.example.jwt.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class JwtUtils {
    @Value("${application.security.jwt.secret-key}")
    private String secretKey;

    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;

    // TODO: Tạo token từ thông tin của user
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", userDetails.getAuthorities());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getSignInKey())
                .compact();
    }

    // TODO: Lấy danh sách claims từ trong token (data trong payload)
    private Claims extractAllClaims(String token) {
        return null;
    }

    // TODO: Lấy username của user từ trong token
    public String extractUsername(String token) {
        return null;
    }

    // TODO: Lấy ngày hết hạn của token
    private Date extractExpiration(String token) {
        return null;
    }

    // TODO: Kiểm tra xem token đã hết hạn hay chưa
    private boolean isTokenExpired(String token) {
        return false;
    }

    // TODO: Kiểm tra token có chuẩn không (trùng username + chưa hết hạn)
    public boolean isTokenValid(String token, UserDetails userDetails) {
        return false;
    }

    // Build secret key jwt
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
