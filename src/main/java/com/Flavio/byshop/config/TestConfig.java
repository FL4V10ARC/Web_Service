package com.Flavio.byshop.config;

// Importações necessárias para a configuração de teste
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.Flavio.byshop.Repositories.UserRepository;
import com.Flavio.byshop.entities.User;
import com.Flavio.byshop.entities.Order;
import com.Flavio.byshop.entities.OrderItem;
import com.Flavio.byshop.entities.Product;
import com.Flavio.byshop.entities.Category;
import com.Flavio.byshop.entities.enums.OrderStatus;
import java.time.Instant;
import java.util.Arrays;
import com.Flavio.byshop.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired; 
import com.Flavio.byshop.Repositories.OrderRepository;
import com.Flavio.byshop.Repositories.ProductRepository;
import com.Flavio.byshop.Repositories.OrdemItemRepository;

@Configuration
@Profile("test") // Esta configuração só será carregada quando o perfil "test" estiver ativo    
public class TestConfig implements CommandLineRunner {

    // Repositório para gerenciar usuários
    @Autowired
    private UserRepository userRepository;
    // Repositório para gerenciar pedidos
    @Autowired
    private OrderRepository orderRepository;
    // Repositório para gerenciar categorias
    @Autowired
    private CategoryRepository categoryRepository;
    // Repositório para gerenciar produtos
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrdemItemRepository orderItemRepository;
    // Método executado na inicialização da aplicação para popular o banco com dados de teste
    @Override
    public void run(String... args) throws Exception {
        // Aqui você pode adicionar código para inicializar dados de teste no banco de dados
        // Por exemplo, criar usuários, produtos, pedidos, etc.
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");
        // salva a lista de categorias (cat1, cat2, cat3) no repositório — persiste as categorias no banco de dados
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        // cria instâncias de produtos com id nulo (será gerado automaticamente), nome, descrição, preço e URL da imagem
        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
       // salva a lista de produtos (p1, p2, p3, p4, p5) no repositório — persiste os produtos no banco de dados
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        // associa os produtos às categorias correspondentes (muitos para muitos)
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
        // salva a lista de usuários (u1, u2) no repositório — persiste os usuários no banco de dados
        userRepository.saveAll(Arrays.asList(u1, u2));
        // cria instâncias de pedidos com id nulo (será gerado automaticamente), instante do pedido, status do pedido e cliente associado
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.waiting_payment, u1); 
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.paid, u2); 
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.shipped, u1);
        // salva a lista de pedidos (o1, o2, o3) no repositório — persiste os pedidos no banco de dados
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
        // salva a lista de itens de pedido (oi1, oi2, oi3, oi4) no repositório — persiste os itens de pedido no banco de dados
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }
}
