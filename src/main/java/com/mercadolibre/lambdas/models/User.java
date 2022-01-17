package com.mercadolibre.lambdas.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class User {

  private Long id;

  private String name;

  private boolean isAdmin;

  private String email;

  private int seniority;

  private String Description;
}
