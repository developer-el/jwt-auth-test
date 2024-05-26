package io.eleutherius.lemonhc.authserver.service;

public interface JwtService {

  String generateJWT(String hospitalKey);

  String getSecretKey(String hospitalKey);

  String updateSecretKey(String hospitalKey);
}
