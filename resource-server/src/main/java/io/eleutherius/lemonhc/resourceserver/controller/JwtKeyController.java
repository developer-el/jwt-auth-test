package io.eleutherius.lemonhc.resourceserver.controller;

import io.eleutherius.lemonhc.resourceserver.model.KidiSecretKey;
import io.eleutherius.lemonhc.resourceserver.service.JwtService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class JwtKeyController {

  private final JwtService jwtService;

  @PostMapping("/v1/security/update")
  public ResponseEntity<Map> updateSecretKey(@RequestBody KidiSecretKey secretKey) {
    log.info("secretKey: {}", secretKey);
    jwtService.updateSecretKey(secretKey.getServiceId(), secretKey.getSecretKey());
    return ResponseEntity.ok().body(Map.of("success", true));
  }

}
