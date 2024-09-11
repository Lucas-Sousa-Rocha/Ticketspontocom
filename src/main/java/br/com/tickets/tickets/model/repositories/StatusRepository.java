package br.com.tickets.tickets.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tickets.tickets.model.entities.Status;

@Repository
public interface StatusRepository extends JpaRepository <Status, Long>{

    Iterable<Status> findBySituacao(String situacao);
}
