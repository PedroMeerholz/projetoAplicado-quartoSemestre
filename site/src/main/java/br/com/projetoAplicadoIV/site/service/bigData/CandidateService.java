package br.com.projetoAplicadoIV.site.service.bigData;

import br.com.projetoAplicadoIV.site.entity.dto.bigData.*;
import br.com.projetoAplicadoIV.site.repository.bigData.CandidateRepository;
import br.com.projetoAplicadoIV.site.service.TokenService;
import br.com.projetoAplicadoIV.site.utils.StringToDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;
    private final TokenService tokenService;
    private final StringToDTO stringToDTO;

    public CandidateService(CandidateRepository candidateRepository, TokenService tokenService, StringToDTO stringToDTO) {
        this.candidateRepository = candidateRepository;
        this.tokenService = tokenService;
        this.stringToDTO = stringToDTO;
    }

    public List<PositionDTO> candidatePosition(String token, String cpf) {
        if(tokenService.verifyToken(cpf, token)) {
            if(candidateRepository.groupByPosition().isPresent()) {
                List<String> positions = candidateRepository.groupByPosition().get();
                return stringToDTO.stringPositionToDTO(positions);
            }
        }
        return new ArrayList<PositionDTO>();
    }

    public List<NationalityDTO> candidateNationality(String token, String cpf) {
        if(tokenService.verifyToken(cpf, token)) {
            if(candidateRepository.groupByNationality().isPresent()) {
                List<String> nationalities = candidateRepository.groupByNationality().get();
                return stringToDTO.stringNationalityToDTO(nationalities);
            }
        }
        return new ArrayList<NationalityDTO>();
    }

    public List<GenderDTO> candidateGender(String token, String cpf) {
        if(tokenService.verifyToken(cpf, token)) {
            if(candidateRepository.groupByGender().isPresent()) {
                List<String> genders = candidateRepository.groupByGender().get();
                return stringToDTO.stringGenderToDTO(genders);
            }
        }
        return new ArrayList<GenderDTO>();
    }

    public List<CandidatureSituationDTO> candidateSituation(String token, String cpf) {
        if(tokenService.verifyToken(cpf, token)) {
            if(candidateRepository.groupByCandidatureSituation().isPresent()) {
                List<String> candidatureSituations = candidateRepository.groupByCandidatureSituation().get();
                return stringToDTO.stringCandidatureSituationToDTO(candidatureSituations);
            }
        }
        return new ArrayList<CandidatureSituationDTO>();
    }

    public List<ScholarityDTO> candidateScholarity(String token, String cpf) {
        if(tokenService.verifyToken(cpf, token)) {
            if(candidateRepository.groupByScholarity().isPresent()) {
                List<String> schooling = candidateRepository.groupByScholarity().get();
                return stringToDTO.stringScholarityToDTO(schooling);
            }
        }
        return new ArrayList<ScholarityDTO>();
    }

    public List<AgeGroupDTO> candidateAgeGroup(String token, String cpf) {
        if(tokenService.verifyToken(cpf, token)) {
            if(candidateRepository.groupByAgeGroup().isPresent()) {
                List<String> ageGroups = candidateRepository.groupByAgeGroup().get();
                return stringToDTO.stringAgeGroupToDTO(ageGroups);
            }
        }
        return new ArrayList<AgeGroupDTO>();
    }

    public List<MaritalStatusDTO> candidateMaritalStatus(String token, String cpf) {
        if(tokenService.verifyToken(cpf, token)) {
            if(candidateRepository.groupByMaritalStatus().isPresent()) {
                List<String> maritalStatus = candidateRepository.groupByMaritalStatus().get();
                return stringToDTO.stringMaritalStatusToDTO(maritalStatus);
            }
        }
        return new ArrayList<MaritalStatusDTO>();
    }
}
