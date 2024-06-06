package br.com.todolist.todolist.entity;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    @Size(min = 5, max = 50, message = "O nome deve ter entre 5 e 50 caracteres!")
    private String nome;

    @Size(max = 140, message = "A descricao deve ter até 140 caracteres!")
    private String descricao;

    @Column(nullable = false)
    @NotNull
    private boolean finalizada;

    private Date dataTermino;

    @Column(nullable = false)
    private Prioridade prioridade = Prioridade.BAIXA;

    public Tarefa(){}

    public Tarefa(String nome, String descricao, boolean finalizada, Date dataTermino, Prioridade prioridade) {
        super();
        this.nome = nome;
        this.descricao = descricao;
        this.finalizada = finalizada;
        this.dataTermino = dataTermino;
        this.prioridade = prioridade;
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getFinalizada() {
        return this.finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public Date getDataTermino() {
        return this.dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Prioridade getPrioridade() {
        return this.prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
}
