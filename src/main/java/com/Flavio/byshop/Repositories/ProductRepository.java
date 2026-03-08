package com.Flavio.byshop.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Flavio.byshop.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}