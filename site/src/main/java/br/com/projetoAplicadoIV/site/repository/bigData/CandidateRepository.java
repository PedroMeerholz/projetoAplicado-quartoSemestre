package br.com.projetoAplicadoIV.site.repository.bigData;

import br.com.projetoAplicadoIV.site.entity.bigData.Candidate;
import br.com.projetoAplicadoIV.site.entity.dto.bigData.PositionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    @Query(value="select cargo_eleicao, count(cargo_eleicao) as quantidade from Candidato group by cargo_eleicao", nativeQuery = true)
    Optional<PositionDTO> groupbyPosition();
}
