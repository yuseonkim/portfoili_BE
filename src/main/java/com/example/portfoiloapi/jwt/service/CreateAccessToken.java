package com.example.portfoiloapi.jwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class CreateAccessToken {
  @Value("86400")
  private Long accessEXP;
  private static String SECRET;

  @Value("IWANTJOB")
  public void setSecret(String secret) {
    SECRET = secret;
  }
  public static String TOKEN_PREFIX = "Bearer ";


  public String execute(String nickname) {
    String jwt = JWT.create()
        .withExpiresAt(new Date(System.currentTimeMillis() + accessEXP * 1000))
        .withClaim("nickname", nickname)
        .sign(Algorithm.HMAC512(SECRET));
    return TOKEN_PREFIX + jwt;
  }
}
