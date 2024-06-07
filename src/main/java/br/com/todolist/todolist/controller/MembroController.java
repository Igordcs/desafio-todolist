package br.com.todolist.todolist.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.todolist.todolist.entity.Membro;
import br.com.todolist.todolist.service.MembroService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/membro/")
public class MembroController {
    @Autowired
    private MembroService membroService;

    @PostMapping("")
    public ResponseEntity<?> salvarMembro(@RequestBody @Valid Membro membro) {
        return new ResponseEntity<Membro>(membroService.salvar(membro), HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException manve) {
        Map<String, String> erros = new HashMap<>();
        manve.getBindingResult().getAllErrors().forEach((erro) -> {
            String campo = ((FieldError) erro).getField();
            String mensagem = erro.getDefaultMessage();
            erros.put(campo, mensagem);
        });
        return erros;
    }
}