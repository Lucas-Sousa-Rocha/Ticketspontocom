package br.com.tickets.tickets.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.tickets.tickets.model.entities.Setores;

@Repository
public interface SetoresRepository extends JpaRepository <Setores, Long> {

    Iterable<Setores> findByStatus(String Status);
}
