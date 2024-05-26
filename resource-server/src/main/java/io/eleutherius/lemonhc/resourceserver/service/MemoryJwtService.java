package io.eleutherius.lemonhc.resourceserver.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemoryJwtService implements JwtService {

  private static String secretKey = null;

  @Override
  public String getSecretKey() {
    return secretKey;
  }

  @Override
  public void updateSecretKey(String newSecretKey) {
    if (newSecretKey == null) {
      throw new IllegalArgumentException("newSecretKey cannot be null");
    }
    secretKey = newSecretKey;
  }

  @Override
  public Boolean validate(String token) {
    if (secretKey == null) {
      throw new IllegalArgumentException("secretKey cannot be null");
    }
    Algorithm algorithm = Algorithm.HMAC512(secretKey);
    var jwtVerifier = JWT.require(algorithm).build();
    try {
      var jwt = jwtVerifier.verify(token);
      log.info("jwt: {}", jwt.getToken());
      return true;
    } catch (JWTVerificationException e) {
      return false;
    }
  }
}
