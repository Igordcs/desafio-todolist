package br.com.todolist.todolist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.todolist.todolist.entity.Tarefa;
import br.com.todolist.todolist.exception.TarefaNaoEncontradaException;
import br.com.todolist.todolist.exception.UsuarioNaoEncontradoException;
import br.com.todolist.todolist.service.TarefaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tarefa/")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @GetMapping("")
    public ResponseEntity<?> listarTodasTarefas() {
        return new ResponseEntity<List<Tarefa>>(tarefaService.listarTarefas(), HttpStatus.OK);
    }
    
    @PostMapping("{id}")
    public ResponseEntity<?> cadastrarTarefa(@RequestBody @Valid Tarefa tarefa, @PathVariable Long id)
    throws UsuarioNaoEncontradoException {
        try {
            return new ResponseEntity<Tarefa>(tarefaService.salvar(tarefa, id), HttpStatus.CREATED);
        } catch (UsuarioNaoEncontradoException e) {
            Map<String, String> resposta = new HashMap<>();
            resposta.put("erro", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarTarefa(@RequestBody @Valid Tarefa tarefa, @PathVariable Long id)
    throws TarefaNaoEncontradaException {
        try {
            return new ResponseEntity<Tarefa>(tarefaService.alterar(tarefa, id), HttpStatus.OK);
        } catch (TarefaNaoEncontradaException e) {
            Map<String, String> resposta = new HashMap<>();
            resposta.put("erro", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarTarefa(@PathVariable Long id)
    throws TarefaNaoEncontradaException {
        try {
            return new ResponseEntity<Tarefa>(tarefaService.deletar(id), HttpStatus.OK);
        } catch (TarefaNaoEncontradaException e) {
            Map<String, String> resposta = new HashMap<>();
            resposta.put("erro", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }
    }

    @PutMapping("/finalizar/{id}")
    public ResponseEntity<?> finalizarTarefa(@PathVariable Long id)
    throws TarefaNaoEncontradaException {
        try {
            return new ResponseEntity<Tarefa>(tarefaService.finalizar(id), HttpStatus.OK);
        } catch (TarefaNaoEncontradaException e) {
            Map<String, String> resposta = new HashMap<>();
            resposta.put("erro", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }
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
