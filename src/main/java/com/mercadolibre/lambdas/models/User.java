package com.mercadolibre.lambdas.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {

  private Long id;

  private String name;

  private boolean isAdmin;

  private String email;
}
