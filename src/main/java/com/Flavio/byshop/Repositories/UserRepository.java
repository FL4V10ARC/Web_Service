package com.Flavio.byshop.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Flavio.byshop.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}