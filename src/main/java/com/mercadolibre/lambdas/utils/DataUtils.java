package com.mercadolibre.lambdas.utils;

import com.mercadolibre.lambdas.enums.Seniority;
import com.mercadolibre.lambdas.models.User;
import java.util.List;

public class DataUtils {

  public static final List<User> users = List.of(
      User.builder().id(1L).name("Diego").isAdmin(true).email("a@a.com")
          .seniority(Seniority.SR.getValue()).build(),
      User.builder().id(2L).name("Haroll").isAdmin(false).email("b@b.com")
          .seniority(Seniority.SSR.getValue()).build(),
      User.builder().id(3L).name("Pepito").isAdmin(false).email("pepito@pepito.com")
          .seniority(Seniority.EXPERT.getValue()).build(),
      User.builder().id(4L).name("Yerry").isAdmin(false).email("yerry@yerry.com")
          .seniority(Seniority.EXPERT.getValue()).build(),
      User.builder().id(5L).name("James").isAdmin(false).email("james@james.com")
          .seniority(Seniority.EXPERT.getValue()).build());

}
