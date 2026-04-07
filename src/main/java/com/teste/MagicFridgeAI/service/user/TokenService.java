package com.teste.MagicFridgeAI.service.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import com.teste.MagicFridgeAI.model.user.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String gerarToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256("food");
            return JWT.create()
                    .withIssuer("Food-API")
                    .withSubject(user.getLogin())
                    .withExpiresAt(dateExpiration())
                    .sign(algorithm);
        }catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token: ", exception);
        }
    }

    public String getSubject(String token){
        Algorithm algorithm = Algorithm.HMAC256("food");
        try {
            return JWT.require(algorithm)
                    .withIssuer("Food-API")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token Inválido ou expirado: ", exception);
        }
    }

    public String recuperarToken(HttpServletRequest request){
        var token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !(token.startsWith("Bearer")))
            return null;
        return token.replace("Bearer ", "");

    }
    private Instant dateExpiration(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
