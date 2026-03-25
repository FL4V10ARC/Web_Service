package com.Flavio.byshop.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Flavio.byshop.entities.OrderItem;

public interface OrdemItemRepository extends JpaRepository<OrderItem, Long> {
}