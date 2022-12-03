package br.com.projetoAplicadoIV.site.repository.bigData;

import br.com.projetoAplicadoIV.site.entity.bigData.Candidate;
import br.com.projetoAplicadoIV.site.entity.dto.bigData.PositionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    @Query(value="select c.position, count(c.position) from Candidate c group by c.position")
    Optional<List<String>> groupByPosition();
}
