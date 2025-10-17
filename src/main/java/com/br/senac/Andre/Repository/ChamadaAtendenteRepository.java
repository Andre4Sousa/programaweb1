package com.br.senac.Andre.Repository;

import com.br.senac.Andre.Entity.ChamadaAtendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadaAtendenteRepository extends JpaRepository<ChamadaAtendente, Integer> {
}
