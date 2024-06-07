package br.com.todolist.todolist.exception;

public class TarefaNaoEncontradaException extends ObjetoNaoEncontradoException {
    private static final Long serialVersionUID = 1L;
    private final Long id;    

    public TarefaNaoEncontradaException(Long id) {
        super("Tarefa");
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
