package io.eleutherius.lemonhc.authserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class KidiSecretKey {

  private String secretKey;

  @Override
  public String toString() {
    return "KidiSecretKey{" +
           "secretKey='" + secretKey + '\'' +
           '}';
  }
}
