package br.com.todolist.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todolist.todolist.entity.Membro;
import br.com.todolist.todolist.exception.UsuarioNaoEncontradoException;
import br.com.todolist.todolist.repository.MembroRepository;

@Service
public class MembroService {
    @Autowired
    private MembroRepository membroRepository;

    public Membro salvar(Membro membro) {
        return membroRepository.save(membro);
    }

    public Membro encontraMembroPorId(Long id) throws UsuarioNaoEncontradoException {
        return membroRepository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }
}
