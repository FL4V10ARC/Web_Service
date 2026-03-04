package com.Flavio.byshop.entities;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

/**
 * Entidade que representa um usuário da aplicação.
 * Implementa {@link Serializable} para que o objeto possa ser
 * convertido em bytes para transmissão ou armazenamento.
 */
@Entity
@Table(name = "tb_user") // Especifica o nome da tabela no banco de dados
public class User implements Serializable{
    private static final long serialVersionUID = 1L; // Identificador para compatibilidade de serialização

    // --- campos da entidade -------------------------------------------------
    /** Identificador único do usuário (geralmente usado como PK no BD). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura o ID para ser gerado automaticamente
    private Long id;
    /** Nome completo do usuário. */
    private String name;
    /** Endereço de email para login e notificações. */
    private String email;
    /** Número de telefone de contato. */
    private String phone;
    /** Senha (deve ser armazenada como hash). */
    private String password;
    /** Lista de pedidos associados ao usuário. */
    @OneToMany(mappedBy = "client") // Define o relacionamento OneToMany com a entidade Order
    private List<Order> orders = new ArrayList<>(); 

    // --- construtores ------------------------------------------------------
    /**
     * Construtor padrão sem parâmetros.
     * Necessário para frameworks como JPA ou Jackson que usam reflexão.
     */
    public User(){
    }

    /**
     * Construtor com todos os campos.
     */
    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // --- getters e setters -------------------------------------------------
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Order> getOrders() {
        return orders;
    }
    // --- identidade de objeto ------------------------------------------------
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        // apenas o id é usado para calcular o hash
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true; // mesma referência
        if (obj == null)
            return false; // comparando com null
        if (getClass() != obj.getClass())
            return false; // deve ser a mesma classe
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true; // ids iguais
    }

}
