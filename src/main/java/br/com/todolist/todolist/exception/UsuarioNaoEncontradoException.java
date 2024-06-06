package br.com.todolist.todolist.exception;

public class UsuarioNaoEncontradoException extends ObjetoNaoEncontradoException{
    private static final Long serialVersionUID = 1L;
    private final Long id;    

    public UsuarioNaoEncontradoException(Long id) {
        super("Membro");
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
