package com.Flavio.byshop.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Flavio.byshop.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}