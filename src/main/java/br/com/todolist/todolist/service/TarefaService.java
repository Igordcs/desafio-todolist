package br.com.todolist.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todolist.todolist.entity.Membro;
import br.com.todolist.todolist.entity.Prioridade;
import br.com.todolist.todolist.entity.Tarefa;
import br.com.todolist.todolist.exception.UsuarioNaoEncontradoException;
import br.com.todolist.todolist.repository.TarefaRepository;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private MembroService membroService;

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Tarefa salvar(Tarefa tarefa, Long criador_id) throws UsuarioNaoEncontradoException {
        Membro criador = membroService.encontraMembroPorId(criador_id);
        tarefa.setCriador(criador);
        return tarefaRepository.save(tarefa);
    }
}
