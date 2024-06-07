package br.com.todolist.todolist.exception;

public class MembroJaCadastradoException extends Exception {
    private static final Long serialVersionUID = 1L;
    private final String email;

    public MembroJaCadastradoException (String email) {
        super("Membro já cadastrado!");
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
}
