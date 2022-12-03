package br.com.projetoAplicadoIV.site.service.bigData;

import br.com.projetoAplicadoIV.site.entity.dto.bigData.NationalityDTO;
import br.com.projetoAplicadoIV.site.entity.dto.bigData.PositionDTO;
import br.com.projetoAplicadoIV.site.repository.bigData.CandidateRepository;
import br.com.projetoAplicadoIV.site.service.TokenService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;
    private final TokenService tokenService;

    public CandidateService(CandidateRepository candidateRepository, TokenService tokenService) {
        this.candidateRepository = candidateRepository;
        this.tokenService = tokenService;
    }

    public List<PositionDTO> candidatePosition(String token, String cpf) {
        if(tokenService.verifyToken(cpf, token)) {
            if(candidateRepository.groupByPosition().isPresent()) {
                List<String> positions = candidateRepository.groupByPosition().get();
                return stringPositionToDTO(positions);
            }
        }
        return new ArrayList<PositionDTO>();
    }

    private List<PositionDTO> stringPositionToDTO(List<String> positions) {
        List<PositionDTO> positionDTOS = new ArrayList<PositionDTO>();
        for(int i=0; i<positions.size();i++) {
            PositionDTO positionDTO = new PositionDTO();
            String position = positions.get(i);
            String[] positionAndQuantity = position.split(",");
            positionDTO.setPosition(positionAndQuantity[0]);
            positionDTO.setQuantity(Integer.valueOf(positionAndQuantity[1]));
            positionDTOS.add(positionDTO);
        }
        return positionDTOS;
    }

    public List<NationalityDTO> candidateNationality(String token, String cpf) {
        if(tokenService.verifyToken(cpf, token)) {
            if(candidateRepository.groupbyNationality().isPresent()) {
                List<String> nationalities = candidateRepository.groupbyNationality().get();
                return stringNationalityToDTO(nationalities);
            }
        }
        return new ArrayList<NationalityDTO>();
    }

    private List<NationalityDTO> stringNationalityToDTO(List<String> nationalities) {
        List<NationalityDTO> nationalityDTOS = new ArrayList<NationalityDTO>();
        for(int i=0; i< nationalities.size();i++) {
            NationalityDTO nationalityDTO = new NationalityDTO();
            String nationality = nationalities.get(i);
            String[] nationalityAndQuantity = nationality.split(",");
            nationalityDTO.setNationality(nationalityAndQuantity[0]);
            nationalityDTO.setQuantity(Integer.valueOf(nationalityAndQuantity[1]));
            nationalityDTOS.add(nationalityDTO);
        }
        return nationalityDTOS;
    }
}
