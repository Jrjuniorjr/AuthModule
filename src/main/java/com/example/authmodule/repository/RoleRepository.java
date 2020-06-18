package com.example.authmodule.repository;

import com.example.authmodule.models.ERole;
import com.example.authmodule.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
    @Query("INSERT INTO tb_roles(name) VALUES('ROLE_USER')")
    void insertRoleUser();
    @Query("INSERT INTO tb_roles(name) VALUES('ROLE_MOD')")
    void insertRoleMod();
    @Query("INSERT INTO tb_roles(name) VALUES('ROLE_ADMIN')")
    void insertRoleAdm();
}
