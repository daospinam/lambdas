package com.mercadolibre.lambdas.utils;

import com.mercadolibre.lambdas.models.User;
import java.util.List;

public class DataUtils {

  public static List<User> users = List.of(
      User.builder().id(1L).name("Diego").isAdmin(true).email("a@a.com").build(),
      User.builder().id(2L).name("Haroll").isAdmin(false).email("b@b.com").build());

}
