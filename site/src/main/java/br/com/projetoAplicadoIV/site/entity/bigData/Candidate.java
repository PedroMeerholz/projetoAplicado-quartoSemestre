package br.com.projetoAplicadoIV.site.entity.bigData;

import javax.persistence.*;

@Entity
@Table(name="candidato")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nome")
    private String name;
    @Column(name="cargo_eleicao")
    private String position;
    @Column(name="partido")
    private String party;
    @Column(name="nacionalidade")
    private String nationality;
    @Column(name="ocupacao")
    private String job;
    @Column(name="genero")
    private String gender;
    @Column(name="numero_candidato")
    private String candidateNumber;
    @Column(name="situacao_candidatura")
    private String candidatureSituation;
    @Column(name="escolaridade")
    private String scholarity;
    @Column(name="faixa_etaria")
    private String ageGroup;
    @Column(name="estado_civil")
    private String maritalStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCandidateNumber() {
        return candidateNumber;
    }

    public void setCandidateNumber(String candidateNumber) {
        this.candidateNumber = candidateNumber;
    }

    public String getCandidatureSituation() {
        return candidatureSituation;
    }

    public void setCandidatureSituation(String candidatureSituation) {
        this.candidatureSituation = candidatureSituation;
    }

    public String getScholarity() {
        return scholarity;
    }

    public void setScholarity(String scholarity) {
        this.scholarity = scholarity;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
}
