package com.Flavio.byshop.entities;

// importações necessárias para a entidade Category
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import java.util.Set;
import java.util.HashSet;

// anotação que marca esta classe como uma entidade JPA (mapeada para tabela no banco)
@Entity
// define o nome da tabela no banco de dados que corresponde a esta entidade
@Table(name = "tb_category")
// classe que representa uma categoria de produtos no sistema
// implementa Serializable para permitir serialização de objetos
public class Category implements Serializable {
    // versão de serialização para garantir compatibilidade entre versões
    private static final long serialVersionUID = 1L;

    // identificador único da categoria (chave primária)
    // @Id marca este campo como chave primária
    // @GeneratedValue determina que o ID será gerado automaticamente pelo banco (auto-increment)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nome da categoria (exemplo: "Eletrônicos", "Roupas", etc)
    private String name;

    // conjunto de produtos associados a esta categoria (relacionamento muitos-para-muitos)
    // @ManyToMany(mappedBy = "categories") indica que o relacionamento é gerenciado pela classe Product
    // HashSet é usado para evitar duplicatas e garantir performance em operações de busca
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();


    // construtor vazio exigido pelo JPA/Hibernate para instanciar a entidade
    public Category() {
    }

    // construtor que recebe id e name para criar uma categoria com valores iniciais
    // utilizado em testes ou quando se quer criar um objeto com dados pré-definidos
    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    // getter que retorna o ID da categoria
    public Long getId() {
        return id;
    }

    // setter que define um novo ID para a categoria
    public void setId(Long id) {
        this.id = id;
    }

    // getter que retorna o nome da categoria
    public String getName() {
        return name;
    }

    // setter que define um novo nome para a categoria
    public void setName(String name) {
        this.name = name;
    }

    // getter que retorna o conjunto de produtos associados a esta categoria
    public Set<Product> getProducts() {
        return products;
    }
    @Override
    // calcula um código hash baseado apenas no ID da categoria
    // isso garante que categorias com o mesmo ID tenham o mesmo hash
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
    // compara duas categorias verificando se têm o mesmo ID
    // retorna verdadeiro se: é o mesmo objeto OU têm o mesmo ID
    // retorna falso se: o objeto é nulo OU não é uma instância de Category
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
        // realiza casting do objeto para Category
        Category other = (Category) obj;
        // compara os IDs: verifica se ambos são nulos ou se são iguais
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        // se tudo passou, as categorias são iguais
        return true;
    }
}
