package com.suyog.SpringBootRest.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.util.*;

@Service
public class JwtService {

    private static final byte[] SECRET_KEY = Base64Coder.decode("mySuperSecretKey");
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    @Autowired
    MyUserDetailService userDetailService;

    public String getToken(String userName) {

        UserDetails userDetails = userDetailService.loadUserByUsername(userName);
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        return JWT.create()
                .withClaim("username", userDetails.getUsername())
                .withClaim("role", roles)// setting all the cliams in one-line
                .withSubject(userName)
                .withIssuedAt(new Date())  // Token creation time
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SECRET_KEY));

    }

    public boolean validateToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET_KEY)).build();
        try {
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractUsername(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getSubject(); // The "sub" field in JWT
    }

    public String extractRole(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("role").asString();
    }

    public Long extractUserId(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("userId").asLong();
    }

}
