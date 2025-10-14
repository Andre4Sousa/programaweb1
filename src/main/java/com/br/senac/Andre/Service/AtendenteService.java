package com.br.senac.Andre.Service;

import com.br.senac.Andre.Config.SecurityConfiguration;
import com.br.senac.Andre.Dto.request.AtendenteDtoRequest;
import com.br.senac.Andre.Dto.request.LoginUserDto;
import com.br.senac.Andre.Dto.response.AtendenteDtoResponse;
import com.br.senac.Andre.Dto.response.RecoveryJwtTokenDto;
import com.br.senac.Andre.Entity.Atendente;
import com.br.senac.Andre.Entity.Role;
import com.br.senac.Andre.Repository.AtendenteRepository;
import com.br.senac.Andre.Repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.List;

public class AtendenteService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private AtendenteRepository atendenteRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    @Autowired
    private RoleRepository roleRepository;



    public List<Atendente> listarAtendentes(){
        return this.atendenteRepository.listarAtendentesAtivos();
    }

    public Atendente listarAtendentePorId(Integer idAtendente){
        return this.atendenteRepository.obterAtendenteAtivoPorId(idAtendente);
    }

    public AtendenteDtoResponse salvar(AtendenteDtoRequest atendenteDtoRequest){
        final String ROLE_PADRAO = "ROLE_CUSTOMER";


//        Role role = roleRepository.findByName(RoleName.valueOf(ROLE_PADRAO))
//                .orElseThrow(() -> new RuntimeException("Role '" + ROLE_PADRAO + "' não encontrada"));
        Role role = roleRepository.findByName(atendenteDtoRequest.getRoleName());

        Atendente atendente = new Atendente();
        atendente.setNome(atendenteDtoRequest.getNome());
        atendente.setLogin(atendenteDtoRequest.getLogin());
        atendente.setSenha(securityConfiguration.passwordEncoder().encode(atendenteDtoRequest.getSenha()));
        atendente.setStatus(1);


        atendente.setRoles(List.of(role));


        Atendente atendenteSalvo = this.atendenteRepository.save(atendente);

        return modelMapper.map(atendenteSalvo, AtendenteDtoResponse.class);
    }

    public AtendenteDtoResponse atualizar(Integer idAtendente, AtendenteDtoRequest usuarioDtoRequest){
        Atendente atendente = this.listarAtendentePorId(idAtendente);
        if (atendente != null){
            modelMapper.map(usuarioDtoRequest, atendente);
            Atendente atendenteTemp = this.atendenteRepository.save(atendente);

            return modelMapper.map(atendenteTemp,AtendenteDtoResponse.class);
        }else{
            return null;
        }

    }




    // Método responsável por autenticar um usuário e retornar um token JWT
    public RecoveryJwtTokenDto authenticateUser(LoginUserDto loginUserDto) {
        // Cria um objeto de autenticação com o email e a senha do usuário
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.login(), loginUserDto.password());

        // Autentica o usuário com as credenciais fornecidas
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // Obtém o objeto UserDetails do usuário autenticado
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Gera um token JWT para o usuário autenticado
        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));
    }

}

