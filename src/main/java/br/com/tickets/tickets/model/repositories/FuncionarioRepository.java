package br.com.tickets.tickets.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tickets.tickets.model.entities.Funcionarios;

@Repository
public interface FuncionarioRepository extends JpaRepository <Funcionarios, Long> {


    Iterable<Funcionarios> findByStatus(String Status);
}
