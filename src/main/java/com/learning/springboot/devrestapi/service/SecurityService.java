package com.learning.springboot.devrestapi.service;

public interface SecurityService {
    String createToken(String subject, long ttlMillis);
    String getSubject(String token);
}
