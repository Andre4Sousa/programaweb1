package com.br.senac.Andre.Dto.request;

import com.br.senac.Andre.Entity.Role;

    import java.util.List;

    public record RecoveryUserDto(

            Long id,
            String email,
            List<Role>roles

    ){
    }

