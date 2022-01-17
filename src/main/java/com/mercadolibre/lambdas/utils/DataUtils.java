package com.mercadolibre.lambdas.utils;

import com.mercadolibre.lambdas.enums.Seniority;
import com.mercadolibre.lambdas.models.User;
import java.util.List;

public class DataUtils {

  public static final List<User> users = List.of(
      User.builder().id(1L).name("Diego").isAdmin(true).email("a@a.com")
          .seniority(Seniority.SR.getValue()).build(),
      User.builder().id(2L).name("Haroll").isAdmin(false).email("b@b.com")
          .seniority(Seniority.SSR.getValue()).build());

}
