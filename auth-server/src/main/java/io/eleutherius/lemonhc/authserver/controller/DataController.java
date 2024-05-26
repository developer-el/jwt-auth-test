package io.eleutherius.lemonhc.authserver.controller;

import io.eleutherius.lemonhc.authserver.client.ResourceServerClient;
import io.eleutherius.lemonhc.authserver.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DataController {

  private final JwtService jwtService;
  private final ResourceServerClient client;

  @GetMapping("/services/data")
  public ResponseEntity<String> getData() {
    final String token = jwtService.generateJWT("123123");
    final String response = client.getMessage("123123", token);
    return ResponseEntity.ok().body(response);
  }
}
