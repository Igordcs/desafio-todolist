package br.com.todolist.todolist.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Membro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "Email invalido!")
    @NotNull
    @Column(nullable = false, unique = true)
    private String email;

    @Size(min = 3, message = "O nome deve ter mais de 3 caracteres!")
    private String nome;

    @OneToMany(mappedBy = "criador", 
               cascade = CascadeType.ALL, 
               orphanRemoval = true)
    @JsonIgnore
    private List<Tarefa> tarefas;

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    
}
