package com.sajid.security.repositories;

import com.sajid.security.dto.UserRoleDto;
import com.sajid.security.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

@Query("SELECT new com.sajid.security.dto.UserRoleDto(u.username, r.role, u.password) " +
        "FROM UserEntity u " +
        "JOIN u.roles r " +
        "WHERE u.username = :username")
    List<UserRoleDto> findRolesofAnUserByUsername(String username);

     Optional<UserEntity> findByUsername(String username);
}
