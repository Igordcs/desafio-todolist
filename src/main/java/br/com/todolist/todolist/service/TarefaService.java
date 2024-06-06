package br.com.todolist.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todolist.todolist.entity.Membro;
import br.com.todolist.todolist.entity.Tarefa;
import br.com.todolist.todolist.exception.TarefaNaoEncontradaException;
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

    public Tarefa alterar(Tarefa novaTarefa, Long tarefaId) throws TarefaNaoEncontradaException {
        Tarefa tarefa = tarefaRepository.findById(tarefaId).orElseThrow(() -> new TarefaNaoEncontradaException(tarefaId));
        tarefa.setNome(novaTarefa.getNome());
        tarefa.setDescricao(novaTarefa.getDescricao());
        tarefa.setPrioridade(novaTarefa.getPrioridade());
        return tarefaRepository.saveAndFlush(tarefa);
    }
}
