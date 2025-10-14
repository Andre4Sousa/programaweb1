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
    @RequestMapping("api/atendente")
    public class AtendenteController {

        private final AtendenteService atendenteService;

        public AtendenteController(AtendenteService atendenteService) {
            this.atendenteService = atendenteService;
        }


        @PostMapping("/criar")
        public ResponseEntity<AtendenteDtoResponse> criar(@RequestBody AtendenteDtoRequest atendenteDtoRequest) {

            return ResponseEntity.ok(atendenteService.salvar(atendenteDtoRequest));
        }

        @PostMapping("/login")
        public ResponseEntity<RecoveryJwtTokenDto> authenticateUser(@RequestBody LoginUserDto loginUserDto) {
            RecoveryJwtTokenDto token = atendenteService.authenticateUser(loginUserDto);
            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        @PutMapping("/alterarStatus/{idAtendente}")
        public ResponseEntity<AtendenteDtoResponse> alterar(
                @PathVariable("idUsuario") Integer idAtendente,
                @RequestBody AtendenteDtoRequest atendenteDtoRequest) {
            return ResponseEntity.ok(atendenteService.atualizar(idAtendente, atendenteDtoRequest));
        }


        @GetMapping("/listar")
        public ResponseEntity<List<Atendente>> listar () {
            return ResponseEntity.ok(atendenteService.listarAtendentes());
        }

        @GetMapping("/listarPorIdAtendente/{idAtendente}")
        public ResponseEntity<Atendente> listarPorIdAtendente (@PathVariable("idAtendente") Integer idAtendente){
            Atendente usuario = atendenteService.listarAtendentePorId(idAtendente);

            if (usuario == null) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(usuario);
            }

        }
    }

