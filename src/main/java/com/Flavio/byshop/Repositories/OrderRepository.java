package com.Flavio.byshop.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Flavio.byshop.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}