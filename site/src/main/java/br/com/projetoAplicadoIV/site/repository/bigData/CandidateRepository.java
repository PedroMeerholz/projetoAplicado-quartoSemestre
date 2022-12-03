package br.com.projetoAplicadoIV.site.repository.bigData;

import br.com.projetoAplicadoIV.site.entity.bigData.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    @Query(value="select c.position, count(c.position) from Candidate c group by c.position order by c.position")
    Optional<List<String>> groupByPosition();

    @Query(value="select c.nationality, count(c.nationality) from Candidate c group by c.nationality order by c.nationality")
    Optional<List<String>> groupByNationality();

    @Query(value="select c.gender, count(c.gender) from Candidate c group by c.gender")
    Optional<List<String>> groupByGender();

    @Query(value="select c.candidatureSituation, count(c.candidatureSituation) from Candidate c group by c.candidatureSituation order by c.candidatureSituation")
    Optional<List<String>> groupByCandidatureSituation();

    @Query(value="select c.scholarity, count(c.scholarity) from Candidate c group by c.scholarity order by c.scholarity")
    Optional<List<String>> groupByScholarity();

    @Query(value="select c.ageGroup, count(c.ageGroup) from Candidate c group by c.ageGroup")
    Optional<List<String>> groupByAgeGroup();

    @Query(value="select c.maritalStatus, count(c.maritalStatus) from Candidate c group by c.maritalStatus")
    Optional<List<String>> groupByMaritalStatus();
}
