package com.br.senac.Andre.Service;

import com.br.senac.Andre.Repository.AtendenteRepository;
import com.br.senac.Andre.Repository.ChamadaAtendenteRepository;
import org.springframework.stereotype.Service;

@Service
public class ChamadaAtendenteService {

    private final ChamadaAtendenteRepository chamadaAtendenteRepository;

    public ChamadaAtendenteService(ChamadaAtendenteRepository chamadaAtendenteRepository) {
        this.chamadaAtendenteRepository = chamadaAtendenteRepository;
    }
}
