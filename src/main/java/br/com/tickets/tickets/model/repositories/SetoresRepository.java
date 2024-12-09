package br.com.tickets.tickets.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.tickets.tickets.model.entities.Setores;

@Repository
public interface SetoresRepository extends JpaRepository <Setores, Long> {

    List<Setores> findByStatus(String Status);
}
