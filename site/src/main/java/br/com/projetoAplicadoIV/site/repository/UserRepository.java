package br.com.projetoAplicadoIV.site.repository;

import br.com.projetoAplicadoIV.site.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
