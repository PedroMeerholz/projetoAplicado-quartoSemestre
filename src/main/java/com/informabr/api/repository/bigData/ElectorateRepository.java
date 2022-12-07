package com.informabr.api.repository.bigData;

import com.informabr.api.entity.bigData.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElectorateRepository extends JpaRepository<Candidate, Long> {
    @Query(value="select e.gender, count(e.gender) from Electorate e group by e.gender order by e.gender")
    Optional<List<String>> groupByGender();

    @Query(value="select e.maritalStatus, count(e.maritalStatus) from Electorate e group by e.maritalStatus order by e.maritalStatus")
    Optional<List<String>> groupByMaritalStatus();

    @Query(value="select e.ageGroup, count(e.ageGroup) from Electorate e group by e.ageGroup order by e.ageGroup")
    Optional<List<String>> groupByAgeGroup();

    @Query(value="select e.scholarity, count(e.scholarity) from Electorate e group by e.scholarity order by e.scholarity")
    Optional<List<String>> groupByScholarity();
}
