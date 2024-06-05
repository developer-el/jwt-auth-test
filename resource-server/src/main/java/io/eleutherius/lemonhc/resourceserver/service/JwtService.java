package io.eleutherius.lemonhc.resourceserver.service;

public interface JwtService {

  String getSecretKey(String serviceId);

  void updateSecretKey(String serviceId, String newSecretKey);

  Boolean validate(String serviceId, String token);
}
