package com.br.senac.Andre.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "atendente")
public class Atendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atendente_id")
    private Integer id;

    @Column(name = "atendente_nome")
    private String nome;

    @Column(name = "atendente_usuario_login")
    private String login;

    @Column(name = "atendente_chave_acesso")
    private String senha;

    @Column(name = "atendente_data_crição")
    private LocalDateTime data;

    @Column(name = "atendente_ativo")
    private Integer status;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name="atendente_role",
            joinColumns = @JoinColumn(name = "atendente_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
            private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}




