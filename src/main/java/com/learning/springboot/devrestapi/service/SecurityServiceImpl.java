package com.learning.springboot.devrestapi.service;

import com.learning.springboot.devrestapi.model.GlobalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    GlobalProperties global;

    public static final String secretKey = "4C8kum4LxyKWYLM78sKdXrzbBjDCFyfX";
    //TODO this token can be made configurable and put in the properties file
    //TODO how to read from properties file  , incorporate this as well in this code

    @Override
    public String createToken(String subject, long ttlMillis) {


        if (ttlMillis <= 0) {
            throw new RuntimeException("Expiry time must be greater than Zero :[" + ttlMillis + "] ");
        }


        // The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .signWith(signatureAlgorithm, signingKey);

        builder.setExpiration(new Date(nowMillis + ttlMillis));
        return builder.compact();

    }


    @Override
    public String getSubject(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(global.getSecret()))
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

}
