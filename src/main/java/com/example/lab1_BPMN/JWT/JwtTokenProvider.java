package com.example.lab1_BPMN.JWT;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.Collectors;
@Component
public class JwtTokenProvider {

    // Секретный ключ для подписи JWT
    private String jwtSecret = "SecretKey";

    // Получить имя пользователя из JWT токена
    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    // Валидация JWT токена
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            // Неверная подпись JWT
        } catch (MalformedJwtException ex) {
            // JWT не корректен
        } catch (ExpiredJwtException ex) {
            // JWT истек
        } catch (UnsupportedJwtException ex) {
            // JWT не поддерживается
        } catch (IllegalArgumentException ex) {
            // Некорректный JWT
        }
        return false;
    }
}
