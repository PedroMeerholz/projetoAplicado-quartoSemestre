package com.informabr.api.repository;

import com.informabr.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "from User where cpf = :cpf")
    Optional<User> findByCPF(@Param("cpf") String cpf);

    @Query(value = "from User where email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query(value= "select id from login order by id desc limit 1", nativeQuery = true)
    Optional<Long> getLastId();

    @Query(value="select token from User where cpf = :cpf")
    Optional<String> getToken(String cpf);
}
