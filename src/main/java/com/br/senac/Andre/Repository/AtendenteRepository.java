package com.br.senac.Andre.Repository;

import com.br.senac.Andre.Entity.Atendente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Integer> {

    @Query("SELECT a FROM Atendente a WHERE a.status >=0")
    List<Atendente> listarAtendentesAtivos();

    @Query("SELECT a FROM Atendente a WHERE a.id = :id AND a.status >=0")
    Atendente obterAtendenteAtivoPorId(@Param("id") int id);


    Optional<Atendente> findByEmail(String login);
}
