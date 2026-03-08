package com.Flavio.byshop.services;
import com.Flavio.byshop.Repositories.ProductRepository;
import com.Flavio.byshop.entities.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    
    public List<Product> findAll() {
        return repository.findAll();
    }
    public Product findById(Long id) {
            Optional<Product> obj = repository.findById(id);
            return obj.get();
    }

}
