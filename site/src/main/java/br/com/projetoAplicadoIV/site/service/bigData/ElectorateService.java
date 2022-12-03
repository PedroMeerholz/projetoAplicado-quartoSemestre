package br.com.projetoAplicadoIV.site.service.bigData;

import br.com.projetoAplicadoIV.site.entity.dto.bigData.AgeGroupDTO;
import br.com.projetoAplicadoIV.site.entity.dto.bigData.GenderDTO;
import br.com.projetoAplicadoIV.site.entity.dto.bigData.MaritalStatusDTO;
import br.com.projetoAplicadoIV.site.entity.dto.bigData.ScholarityDTO;
import br.com.projetoAplicadoIV.site.repository.bigData.ElectorateRepository;
import br.com.projetoAplicadoIV.site.service.TokenService;
import br.com.projetoAplicadoIV.site.utils.StringToDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElectorateService {
    private final ElectorateRepository electorateRepository;
    private final TokenService tokenService;
    private final StringToDTO stringToDTO;

    public ElectorateService(ElectorateRepository electorateRepository, TokenService tokenService, StringToDTO stringToDTO) {
        this.electorateRepository = electorateRepository;
        this.tokenService = tokenService;
        this.stringToDTO = stringToDTO;
    }

    public List<GenderDTO> electorateGender(String token, String cpf) {
        if(tokenService.verifyToken(cpf, token)) {
            if(electorateRepository.groupByGender().isPresent()) {
                List<String> genders = electorateRepository.groupByGender().get();
                return stringToDTO.stringGenderToDTO(genders);
            }
        }
        return new ArrayList<GenderDTO>();
    }

    public List<MaritalStatusDTO> electorateMaritalStatus(String token, String cpf) {
        if(tokenService.verifyToken(cpf, token)) {
            if(electorateRepository.groupByMaritalStatus().isPresent()) {
                List<String> maritalStatus = electorateRepository.groupByMaritalStatus().get();
                return  stringToDTO.stringMaritalStatusToDTO(maritalStatus);
            }
        }
        return new ArrayList<MaritalStatusDTO>();
    }

    public List<AgeGroupDTO> electorateAgeGroup(String token, String cpf) {
        if(tokenService.verifyToken(cpf, token)) {
            if(electorateRepository.groupByAgeGroup().isPresent()) {
                List<String> ageGroups = electorateRepository.groupByAgeGroup().get();
                return stringToDTO.stringAgeGroupToDTO(ageGroups);
            }
        }
        return new ArrayList<AgeGroupDTO>();
    }

    public List<ScholarityDTO> electorateScholarity(String token, String cpf) {
        if(tokenService.verifyToken(cpf, token)) {
            if(electorateRepository.groupByScholarity().isPresent()) {
                List<String> schooling = electorateRepository.groupByScholarity().get();
                System.out.println(schooling.get(0));
                return stringToDTO.stringScholarityToDTO(schooling);
            }
        }
        return new ArrayList<ScholarityDTO>();
    }
}
