package br.com.projetoAplicadoIV.site.controller.bigData;

import br.com.projetoAplicadoIV.site.entity.dto.bigData.CandidatureSituationDTO;
import br.com.projetoAplicadoIV.site.entity.dto.bigData.GenderDTO;
import br.com.projetoAplicadoIV.site.entity.dto.bigData.NationalityDTO;
import br.com.projetoAplicadoIV.site.entity.dto.bigData.PositionDTO;
import br.com.projetoAplicadoIV.site.service.bigData.CandidateService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/position/{cpf}")
    public List<PositionDTO> getCandidatePosition(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable("cpf") String cpf) {
        return candidateService.candidatePosition(token, cpf);
    }

    @GetMapping("/nationality/{cpf}")
    public List<NationalityDTO> getCandidateNationality(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable("cpf") String cpf) {
        return candidateService.candidateNationality(token, cpf);
    }

    @GetMapping("/gender/{cpf}")
    public List<GenderDTO> getCandidateGender(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable("cpf") String cpf) {
        return candidateService.candidateGender(token, cpf);
    }

    @GetMapping("/situation/{cpf}")
    public List<CandidatureSituationDTO> getCandidateSituation(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable("cpf") String cpf) {
        return candidateService.candidateSituation(token, cpf);
    }
}
