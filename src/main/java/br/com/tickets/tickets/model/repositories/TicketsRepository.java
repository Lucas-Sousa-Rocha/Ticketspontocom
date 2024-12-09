package br.com.tickets.tickets.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tickets.tickets.model.entities.Tickets;

@Repository
public interface TicketsRepository extends JpaRepository<Tickets, Long> {


    @Query("SELECT p FROM Tickets p WHERE p.titulo LIKE %:titulo%")
    Iterable<Tickets> findBytitulo(@Param("titulo") String titulo);

    @Query("SELECT t FROM Tickets t WHERE t.status.id != 3")
    List<Tickets> findByActive();

    @Query("SELECT t FROM Tickets t WHERE t.status.id = 3")
    List<Tickets> findByFinish();
}
