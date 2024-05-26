package io.eleutherius.lemonhc.resourceserver.controller;

import io.eleutherius.lemonhc.resourceserver.model.HelloModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

  @GetMapping("/messages")
  public ResponseEntity<HelloModel> getMessage() {
    return ResponseEntity.ok().body(new HelloModel("Hong"));
  }
}
