package br.com.todolist.todolist.exception;

public class ObjetoNaoEncontradoException extends Exception {
    private static final Long serialVersionUID = 1L;

    public ObjetoNaoEncontradoException (String classe) {
        super(String.format("%s nao foi encontrado", classe));
    }
}
