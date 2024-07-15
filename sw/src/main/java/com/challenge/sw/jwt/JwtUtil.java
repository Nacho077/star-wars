package com.challenge.sw.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

public class JwtUtil {

    private static final SignatureAlgorithm ALGORITHM = SignatureAlgorithm.HS256;

    private static final Key KEY = Keys.secretKeyFor(ALGORITHM);

    private static final int EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    public static String generateToken(UserDetails user) {
        var now = new Date(System.currentTimeMillis());
        var expireDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        var claims = new HashMap<String, String>();

        claims.put("password", user.getPassword());
        claims.put("subject", user.getUsername());

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(KEY, ALGORITHM)
                .compact();
    }

    public static Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public static String getSubjectFromToken(String token) {
        Claims claims = getClaims(token);

        return (String) claims.get("subject");
    }

    public static boolean isValidToken(String token, UserDetails userDetails) {
        var subject = getSubjectFromToken(token);

        return subject.equals(userDetails.getUsername()) && !getClaims(token).getExpiration().before(new Date());
    }
}
