package br.com.tickets.tickets.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tickets.tickets.model.entities.Funcionarios;

@Repository
public interface FuncionarioRepository extends JpaRepository <Funcionarios, Long> {


    List<Funcionarios> findByStatus(String Status);
}
