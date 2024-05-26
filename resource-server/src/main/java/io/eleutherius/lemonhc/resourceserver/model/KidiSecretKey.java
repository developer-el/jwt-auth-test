package io.eleutherius.lemonhc.resourceserver.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KidiSecretKey {

  private String secretKey;

  @Override
  public String toString() {
    return "KidiSecretKey{" +
           "secretKey='" + secretKey + '\'' +
           '}';
  }
}
