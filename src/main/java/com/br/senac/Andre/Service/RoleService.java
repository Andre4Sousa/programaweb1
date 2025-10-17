package com.br.senac.Andre.Service;


import com.br.senac.Andre.Repository.AtendenteRepository;
import com.br.senac.Andre.Repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
