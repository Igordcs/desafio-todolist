package br.com.todolist.todolist.exception;

public class UsuarioNaoEncontradoException extends ObjetoNaoEncontradoException{
    private static final Long serialVersionUID = 1L;
    private final Long id;    
    private final String email;    

    public UsuarioNaoEncontradoException(Long id) {
        super("Membro");
        this.id = id;
        this.email = null;
    }

    public UsuarioNaoEncontradoException(String email) {
        super("Membro");
        this.id = null;
        this.email = email;
    }

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }
}
