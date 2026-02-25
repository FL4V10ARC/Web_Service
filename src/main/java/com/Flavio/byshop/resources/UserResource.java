package com.Flavio.byshop.resources;
import com.Flavio.byshop.entities.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users") // Define o endpoint base para esta classe de recurso
public class UserResource {
  @GetMapping
public ResponseEntity<List<user>> findAll() {

    user u = new user(1L, "Flavio", "flavio@email.com", "123456789", "123456");

    List<user> list = new ArrayList<>();
    list.add(u);

    return ResponseEntity.ok().body(list);
}
}
