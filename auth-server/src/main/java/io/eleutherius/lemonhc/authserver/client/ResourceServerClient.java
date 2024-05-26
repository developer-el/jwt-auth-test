package io.eleutherius.lemonhc.authserver.client;

import io.eleutherius.lemonhc.authserver.model.KidiSecretKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
public class ResourceServerClient {

  public void genSecretKey(String hospitalKey, String secretKey) {
    // 도메인 조회하고 불라불라
    final var restClient = RestClient.builder()
        .baseUrl("http://localhost:8080")
        .build();
    final ResponseEntity<Void> response = restClient.post()
        .uri("/kidi/info-update")
        .contentType(MediaType.APPLICATION_JSON)
        .body(new KidiSecretKey(secretKey))
        .retrieve()
        .toBodilessEntity();

    if (!response.getStatusCode().is2xxSuccessful()) {
      // 이상 확인?
    }
  }

  public String getMessage(String hospitalKey, String token) {
    // 도메인 조회하고 불라불라
    final var restClient = RestClient.builder()
        .baseUrl("http://localhost:8080")
        .build();

    log.info("token: {}", token);

    final String response = restClient.get()
        .uri("/messages")
        .header("x-kidi-auth", token)
        .retrieve()
        .body(String.class);
    return response;
  }
}
