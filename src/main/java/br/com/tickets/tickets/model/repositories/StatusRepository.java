package br.com.tickets.tickets.model.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tickets.tickets.model.entities.Status;

@Repository
public interface StatusRepository extends JpaRepository <Status, Long>{

    List<Status> findBySituacao(String situacao);
}
