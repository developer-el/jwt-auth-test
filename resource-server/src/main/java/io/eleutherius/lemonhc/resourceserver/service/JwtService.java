package io.eleutherius.lemonhc.resourceserver.service;

public interface JwtService {

  String getSecretKey();

  void updateSecretKey(String newSecretKey);

  Boolean validate(String token);
}
