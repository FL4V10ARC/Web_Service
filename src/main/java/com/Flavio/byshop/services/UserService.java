package com.Flavio.byshop.services;
import com.Flavio.byshop.Repositories.UserRepository;
import com.Flavio.byshop.entities.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    
    public List<User> findAll() {
        return repository.findAll();
    }
    public User findById(Long id) {
            Optional<User> obj = repository.findById(id);
            return obj.get();
    }

}
