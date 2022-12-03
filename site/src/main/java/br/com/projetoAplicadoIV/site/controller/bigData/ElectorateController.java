package br.com.projetoAplicadoIV.site.controller.bigData;

import br.com.projetoAplicadoIV.site.entity.dto.bigData.AgeGroupDTO;
import br.com.projetoAplicadoIV.site.entity.dto.bigData.GenderDTO;
import br.com.projetoAplicadoIV.site.entity.dto.bigData.MaritalStatusDTO;
import br.com.projetoAplicadoIV.site.entity.dto.bigData.ScholarityDTO;
import br.com.projetoAplicadoIV.site.service.bigData.ElectorateService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/electorate")
public class ElectorateController {
    private final ElectorateService electorateService;

    public ElectorateController(ElectorateService electorateService) {
        this.electorateService = electorateService;
    }

    @GetMapping("/gender/{cpf}")
    public List<GenderDTO> getElectorateGender(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable("cpf") String cpf) {
        return electorateService.electorateGender(token, cpf);
    }

    @GetMapping("/maritalStatus/{cpf}")
    public List<MaritalStatusDTO> getElectorateMaritalStatus(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable("cpf") String cpf) {
        return electorateService.electorateMaritalStatus(token, cpf);
    }

    @GetMapping("/age/{cpf}")
    public List<AgeGroupDTO> getElectorateAgeGroup(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable("cpf") String cpf) {
        return electorateService.electorateAgeGroup(token, cpf);
    }

    @GetMapping("/scholarity/{cpf}")
    public List<ScholarityDTO> getElectorateScholarity(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable("cpf") String cpf) {
        return electorateService.electorateScholarity(token, cpf);
    }
}
