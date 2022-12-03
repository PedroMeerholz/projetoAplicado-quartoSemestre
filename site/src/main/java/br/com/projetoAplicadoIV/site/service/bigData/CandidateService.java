package br.com.projetoAplicadoIV.site.service.bigData;

import br.com.projetoAplicadoIV.site.entity.dto.bigData.PositionDTO;
import br.com.projetoAplicadoIV.site.repository.bigData.CandidateRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public PositionDTO candidatePosition() {
        if(candidateRepository.groupbyPosition().isPresent()) {
            return candidateRepository.groupbyPosition().get();
        }
        return new PositionDTO();
    }
}
