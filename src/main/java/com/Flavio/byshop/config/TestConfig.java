package com.Flavio.byshop.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.Flavio.byshop.Repositories.UserRepository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired; 
import com.Flavio.byshop.entities.user;

@Configuration
@Profile("test") // Esta configuração só será carregada quando o perfil "test" estiver ativo    
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @SuppressWarnings("null")
    @Override
    public void run(String... args) throws Exception {
        // Aqui você pode adicionar código para inicializar dados de teste no banco de dados
        // Por exemplo, criar usuários, produtos, pedidos, etc.
        user u1 = new user(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
        user u2 = new user(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
        userRepository.saveAll(Arrays.asList(u1, u2));
    }


}
