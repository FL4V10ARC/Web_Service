package com.Flavio.byshop.entities;

// importações para coleções
import java.util.Set;
import java.util.HashSet;

// importações do JPA/Hibernate para mapeamento de entidades
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinTable;
<<<<<<< HEAD
import jakarta.persistence.JoinColumn;
=======
import jakarta.persistence.JoinColumn;  
>>>>>>> 7cb562544ee4fff0cfa275fc7ba5e5613f0d49a2

// importação para serialização
import java.io.Serializable;

// anotação que marca esta classe como uma entidade JPA (mapeada para tabela no banco de dados)
@Entity
// define o nome da tabela no banco de dados que corresponde a esta entidade
@Table(name = "tb_product")
// classe que representa um produto no sistema
// cada produto pode estar associado a múltiplas categorias
// implementa Serializable para permitir serialização de objetos
public class Product implements Serializable{
    // versão de serialização para garantir compatibilidade entre versões
    private static final long serialVersionUID = 1L;

    // identificador único do produto (chave primária)
    // @Id marca este campo como chave primária
    // @GeneratedValue determina que o ID será gerado automaticamente pelo banco (auto-increment)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nome do produto (exemplo: "Notebook Dell", "iPhone 15", etc)
    private String name;

    // descrição detalhada do produto
    private String description;

    // preço do produto
    private Double price;

    // URL da imagem do produto
    private String imgUrl;
    
    // conjunto de categorias associadas a este produto (relacionamento muitos-para-muitos)
    // @ManyToMany indica que um produto pode estar em múltiplas categorias
    //            e uma categoria pode ter múltiplos produtos
    // @JoinTable define a tabela de junção que conecta produtos e categorias
    //   name: nome da tabela de junção
    //   joinColumns: especifica a coluna que referencia Product
    //   inverseJoinColumns: especifica a coluna que referencia Category
    // HashSet é usado para evitar duplicatas e garantir performance
    @ManyToMany
    @JoinTable(name = "tb_product_category",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    // construtor vazio exigido pelo JPA/Hibernate para instanciar a entidade
    public Product() {
    }

    // construtor completo que recebe todos os parâmetros
    // parâmetros:
    //   id: identificador único do produto
    //   name: nome do produto
    //   description: descrição detalhada do produto
    //   price: preço do produto
    //   imgUrl: URL da imagem do produto
    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }
    // getter que retorna o ID do produto
    public Long getId() {
        return id;
    }

    // setter que define um novo ID para o produto
    public void setId(Long id) {
        this.id = id;
    }

    // getter que retorna o nome do produto
    public String getName() {
        return name;
    }

    // setter que define um novo nome para o produto
    public void setName(String name) {
        this.name = name;
    }

    // getter que retorna a descrição do produto
    public String getDescription() {
        return description;
    }

    // setter que define uma nova descrição para o produto
    public void setDescription(String description) {
        this.description = description;
    }

    // getter que retorna o preço do produto
    public Double getPrice() {
        return price;
    }

    // setter que define um novo preço para o produto
    public void setPrice(Double price) {
        this.price = price;
    }

    // getter que retorna a URL da imagem do produto
    public String getImgUrl() {
        return imgUrl;
    }

    // setter que define uma nova URL de imagem para o produto
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    // getter que retorna o conjunto de categorias associadas ao produto
    public Set<Category> getCategories() {
        return categories;
    }
    @Override
    // calcula um código hash baseado apenas no ID do produto
    // isso garante que produtos com o mesmo ID tenham o mesmo hash
    // importante para usar objetos Product em estruturas como HashMap e HashSet
    public int hashCode() {
        // utiliza o número primo 31 como fator multiplicador (padrão Java)
        final int prime = 31;
        // inicializa o resultado
        int result = 1;
        // combina o hash do ID com o resultado
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    // compara dois produtos verificando se têm o mesmo ID
    // retorna verdadeiro se: é o mesmo objeto OU têm o mesmo ID
    // retorna falso se: o objeto é nulo OU não é uma instância de Product
    public boolean equals(Object obj) {
        // verifica se é o mesmo objeto na memória
        if (this == obj)
            return true;
        // verifica se o objeto comparado é nulo
        if (obj == null)
            return false;
        // verifica se são da mesma classe
        if (getClass() != obj.getClass())
            return false;
        // realiza casting para Product
        Product other = (Product) obj;
        // compara os IDs: verifica se ambos são nulos ou se são iguais
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        // se tudo passou, os produtos são iguais
        return true;
    }
}
