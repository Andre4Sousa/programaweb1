package com.br.senac.Andre.Controler;

import com.br.senac.Andre.Dto.request.AtendenteDtoRequest;
import com.br.senac.Andre.Dto.request.LoginUserDto;
import com.br.senac.Andre.Dto.response.AtendenteDtoResponse;
import com.br.senac.Andre.Dto.response.RecoveryJwtTokenDto;
import com.br.senac.Andre.Entity.Atendente;
import com.br.senac.Andre.Service.AtendenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



    @RestController
    @RequestMapping("/api/atendente")
    public class AtendenteController {

        private final AtendenteService atendenteService;

        public AtendenteController(AtendenteService atendenteService) {
            this.atendenteService = atendenteService;
        }

        public ResponseEntity <List<Atendente>> listarTodos(){
            return ResponseEntity.ok(atendenteService.listarTodos());
        }

        @GetMapping("/listarporid/{id}")
        public ResponseEntity<Atendente> listarPorId(@PathVariable("id") Integer id){
            return ResponseEntity.ok(atendenteService.listarPorId(id));
        }
    }

