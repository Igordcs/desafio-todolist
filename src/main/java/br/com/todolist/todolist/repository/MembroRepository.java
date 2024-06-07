package br.com.todolist.todolist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.todolist.todolist.entity.Membro;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {
    public Optional<Membro> findByEmail(String Email);
}
