package io.eleutherius.lemonhc.authserver.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import io.eleutherius.lemonhc.authserver.client.ResourceServerClient;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleJwtService implements JwtService {

  private final Map<String, String> keys = new HashMap<>();

  private final ResourceServerClient client;

  @Override
  public String generateJWT(String hospitalKey) {
    String key = this.getSecretKey(hospitalKey);
    final var algorithm = Algorithm.HMAC512(key);
    return JWT.create()
        .withExpiresAt(Instant.now().plus(30, ChronoUnit.MINUTES))
        .withIssuedAt(Instant.now())
        .withJWTId(UUID.randomUUID().toString())
        .sign(algorithm);
  }

  @Override
  public String getSecretKey(String hospitalKey) {
    if (keys.get(hospitalKey) == null) {
      updateSecretKey(hospitalKey);
    }
    return keys.get(hospitalKey);
  }

  @Override
  public String updateSecretKey(String hospitalKey) {
    String key = NanoIdUtils.randomNanoId();
    client.genSecretKey(hospitalKey, key);
    keys.put(hospitalKey, key);
    return key;
  }
}
