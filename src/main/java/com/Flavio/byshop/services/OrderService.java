package com.Flavio.byshop.services;
import com.Flavio.byshop.Repositories.OrderRepository;
import com.Flavio.byshop.entities.Order;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    
    public List<Order> findAll() {
        return repository.findAll();
    }
    public Order findById(Long id) {
            Optional<Order> obj = repository.findById(id);
            return obj.get();
    }

}
