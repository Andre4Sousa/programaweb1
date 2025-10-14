package com.br.senac.Andre.Repository;



import com.br.senac.Andre.Entity.Role;
import com.br.senac.Andre.Entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(RoleName name);
}
