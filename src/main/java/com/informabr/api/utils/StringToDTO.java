package com.informabr.api.utils;

import com.informabr.api.entity.dto.bigData.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StringToDTO {

    public List<PositionDTO> stringPositionToDTO(List<String> positions) {
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

    public List<NationalityDTO> stringNationalityToDTO(List<String> nationalities) {
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

    public List<GenderDTO> stringGenderToDTO(List<String> genders) {
        List<GenderDTO> genderDTOS = new ArrayList<GenderDTO>();
        for(int i=0; i<genders.size(); i++) {
            GenderDTO genderDTO = new GenderDTO();
            String gender = genders.get(i);
            String[] genderAndQuantity = gender.split(",");
            genderDTO.setGender(genderAndQuantity[0]);
            genderDTO.setQuantity(Integer.valueOf(genderAndQuantity[1]));
            genderDTOS.add(genderDTO);
        }
        return genderDTOS;
    }

    public List<CandidatureSituationDTO> stringCandidatureSituationToDTO(List<String> situations) {
        List<CandidatureSituationDTO> candidatureSituationDTOS = new ArrayList<CandidatureSituationDTO>();
        for(int i=0;i<situations.size();i++) {
            CandidatureSituationDTO candidatureSituationDTO = new CandidatureSituationDTO();
            String situation = situations.get(i);
            String[] situationAndQuantity = situation.split(",");
            candidatureSituationDTO.setSituation(situationAndQuantity[0]);
            candidatureSituationDTO.setQuantity(Integer.valueOf(situationAndQuantity[1]));
            candidatureSituationDTOS.add(candidatureSituationDTO);
        }
        return candidatureSituationDTOS;
    }

    public List<ScholarityDTO> stringScholarityToDTO(List<String> schooling) {
        List<ScholarityDTO> schoolingDTOS = new ArrayList<ScholarityDTO>();
        for(int i=0;i< schooling.size();i++) {
            ScholarityDTO scholarityDTO = new ScholarityDTO();
            String scholarity = schooling.get(i);
            String[] scholarityAndQuantity = scholarity.split(",");
            scholarityDTO.setScholarity(scholarityAndQuantity[0]);
            scholarityDTO.setQuantity(Integer.valueOf(scholarityAndQuantity[1]));
            schoolingDTOS.add(scholarityDTO);
        }
        return schoolingDTOS;
    }

    public List<AgeGroupDTO> stringAgeGroupToDTO(List<String> ageGroups) {
        List<AgeGroupDTO> ageGroupDTOS = new ArrayList<AgeGroupDTO>();
        for(int i=0;i< ageGroups.size();i++) {
            AgeGroupDTO ageGroupDTO = new AgeGroupDTO();
            String ageGroup = ageGroups.get(i);
            String[] ageGroupAndQuantity = ageGroup.split(",");
            ageGroupDTO.setAgeGroup(ageGroupAndQuantity[0]);
            ageGroupDTO.setQuantity(Integer.valueOf(ageGroupAndQuantity[1]));
            ageGroupDTOS.add(ageGroupDTO);
        }
        return ageGroupDTOS;
    }

    public List<MaritalStatusDTO> stringMaritalStatusToDTO(List<String> maritalStatus) {
        List<MaritalStatusDTO> maritalStatusDTOS = new ArrayList<MaritalStatusDTO>();
        for(int i=0; i<maritalStatus.size(); i++) {
            MaritalStatusDTO maritalStatusDTO = new MaritalStatusDTO();
            String maritalStatusString = maritalStatus.get(i);
            String[] maritalStatusAndQuantity = maritalStatusString.split(",");
            maritalStatusDTO.setMaritalStatus(maritalStatusAndQuantity[0]);
            maritalStatusDTO.setQuantity(Integer.valueOf(maritalStatusAndQuantity[1]));
            maritalStatusDTOS.add(maritalStatusDTO);
        }
        return maritalStatusDTOS;
    }
}
