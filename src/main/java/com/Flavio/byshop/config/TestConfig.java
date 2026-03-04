package com.Flavio.byshop.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.Flavio.byshop.Repositories.UserRepository;
import com.Flavio.byshop.entities.User;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired; 

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
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
        // salva a lista de usuários (u1, u2) no repositório — persiste os usuários no banco de dados
        userRepository.saveAll(Arrays.asList(u1, u2));
    }


}
