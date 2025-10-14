package com.br.senac.Andre.Controler;

import com.br.senac.Andre.Entity.Atendente;
import com.br.senac.Andre.Service.AtendenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class RegistroDeChamada {

    @GetMapping("/RegistrarChamadaPorIdAtendente/{idAtendente}")
    public ResponseEntity<Atendente> listarPorIdAtendente(@PathVariable("idAtendente") Integer idAtendente) {
        AtendenteService atendenteService = new AtendenteService();
        Atendente usuario = atendenteService.listarAtendentePorId(idAtendente);

        if (usuario == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(usuario);
        }
    }
}
