package com.java.IroncladVaultManagementSystem.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {
	

    private static Key key = null;
    private final static long EXPIRATION = 1000L * 60 * 60; // 1 hour

    /**
     * Inject secret from application.properties: jwt.secret=your_very_long_secret_here
     * Make sure the secret is at least 32 characters (256 bits) for HS256.
     */
    public JwtUtil(@Value("${jwt.secret:myDefaultVeryLongDevSecretThatShouldBeChanged!}") String secret) {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);

        // Ensure a minimum length (32 bytes) for HS256. For production, use a proper secret/key.
        if (keyBytes.length < 32) {
            keyBytes = Arrays.copyOf(keyBytes, 32); // pad with zeros (dev only)
        }
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public boolean isTokenExpired(String token) {
        Date exp = extractExpiration(token);
        return exp != null && exp.before(new Date());
    }

    public static String generateToken(String username) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + EXPIRATION);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token, String username) {
        try {
            final String tokenUsername = extractUsername(token);
            return tokenUsername.equals(username) && !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }
}

