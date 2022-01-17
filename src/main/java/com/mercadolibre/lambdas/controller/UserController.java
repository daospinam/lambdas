package com.mercadolibre.lambdas.controller;

import com.mercadolibre.lambdas.models.User;
import com.mercadolibre.lambdas.utils.DataUtils;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @GetMapping("/users")
  public List<User> get() {
    return DataUtils.users;
  }

  @GetMapping("/users/{id}")
  public User getById(@PathVariable Long id) {
    return DataUtils.users.stream()
        .filter(u -> Objects.equals(u.getId(), id))
        .findFirst().orElse(getNotFound());
  }

  @GetMapping("/users/{id}/description")
  public User getByIdWithDescription(@PathVariable Long id) {
    var users = DataUtils.users.stream()
        .filter(u -> Objects.equals(u.getId(), id))
        .collect(Collectors.toList());

    users.forEach(
        user -> user.setDescription("the best!!!")
    );

    return users.stream().findFirst().orElse(getNotFound());
  }

  private User getNotFound() {
    return User.builder().Description("Not Found").build();
  }

}
