package br.com.projetoAplicadoIV.site.repository;

import br.com.projetoAplicadoIV.site.entity.User;
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
}
