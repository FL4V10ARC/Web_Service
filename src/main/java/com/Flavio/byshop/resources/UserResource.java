package com.Flavio.byshop.resources;
import com.Flavio.byshop.entities.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para gerenciar operações relacionadas a usuários.
 * Fornece endpoints HTTP para requisições sobre usuários.
 */
@RestController
@RequestMapping(value = "/users") // Define o endpoint base como "/users"
public class UserResource {
  
  /**
   * Busca todos os usuários cadastrados.
   * 
   * @return ResponseEntity contendo uma lista de usuários e código HTTP 200
   */
  @GetMapping
  public ResponseEntity<List<user>> findAll() {
    
    // Cria um usuário de exemplo
    user u = new user(1L, "Flavio", "flavio@email.com", "123456789", "123456");

    // Inicializa a lista que será retornada
    List<user> list = new ArrayList<>();
    // Adiciona o usuário à lista
    list.add(u);

    // Retorna a lista com status HTTP 200 (OK)
    return ResponseEntity.ok().body(list);
  }
}
