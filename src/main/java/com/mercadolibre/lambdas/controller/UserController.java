package com.mercadolibre.lambdas.controller;

import com.mercadolibre.lambdas.enums.Seniority;
import com.mercadolibre.lambdas.models.User;
import com.mercadolibre.lambdas.utils.DataUtils;
import java.util.Comparator;
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
    var users = DataUtils.users.stream()
        .sorted(Comparator.comparing(User::getName))
        .collect(Collectors.toList());

    // Vanilla
    for (User user : users) {
      System.out.println(user);
    }

    //Lambda
    users.forEach(u -> System.out.println(u));

    //Method Reference
    users.forEach(System.out::println);

    return users;
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

    users.stream().findFirst().ifPresentOrElse((value)
            -> System.out.println("Value is present, its: " + value),
        ()
            -> System.out.println("Value is empty"));

    return users.stream().findFirst().orElse(getNotFound());
  }

  @GetMapping("/users/experts")
  public List<User> getByIdSeniority() {
    var users = DataUtils.users.stream()
        .filter(u -> Objects.equals(u.getSeniority(), Seniority.EXPERT.getValue()))
        .collect(Collectors.toList());

    users.stream().filter(u -> Objects.equals(u.getSeniority(), Seniority.EXPERT.getValue()))
        .forEach(user -> user.setDescription("the best expert!!!"));

    /*users.forEach(
        user -> user.setDescription("the best expert!!!")
    );*/

    return users.stream().limit(2).collect(Collectors.toList());
  }

  private User getNotFound() {
    return User.builder().Description("Not Found").build();
  }

}
