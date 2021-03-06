package ht.ihsi.rgph.mobile.epc.Models;

/**
 * Created by JFDuverseau on 9/28/2017.
 */

public class AncienMembreModel extends BaseModel  {

    //region [ ATTRIBUTS ]
    private Long ancienMembreId;
    private Long menageId;
    private Long logeId;
    private Long batimentId;
    private String sdeId;
    private Short q1Ordre;
    private String q2Prenom;
    private String q3Nom;
    private Short q4Sexe;
    private Short q5Statut;
    private Short q6EtaitMembreMenage;
    private Short q7DateQuitterMenageJour;
    private Short qADateQuitterMenageMois;
    private String qADateQuitterMenageAnnee;
    private Short q8DateNaissanceJour;
    private Short q8DateNaissanceMois;
    private String q8DateNaissanceAnnee;
    private Integer q9Age;
    private Short q10RelationAvecChefMenage;
    private Short q11Nationalite;
    private String q11PaysNationalite;
    private Short q12NiveauAcademique;
    private Short q13StatutMatrimonial;
    private Short statut;
    private Boolean isValidated;
    private Boolean isFieldAllFilled;
    private String dateDebutCollecte;
    private String dateFinCollecte;
    private Integer dureeSaisie;
    private Boolean isContreEnqueteMade;
    private String codeAgentRecenceur;
    //endregion

    //region [ CONTRUCTEURS ]

    //endregion

    //region [ GETTER & SETTER ]
    public Long getAncienMembreId() {
        return ancienMembreId;
    }

    public void setAncienMembreId(Long ancienMembreId) {
        this.ancienMembreId = ancienMembreId;
    }

    public Long getMenageId() {
        return menageId;
    }

    public void setMenageId(Long menageId) {
        this.menageId = menageId;
    }

    public Long getLogeId() {
        return logeId;
    }

    public void setLogeId(Long logeId) {
        this.logeId = logeId;
    }

    public Long getBatimentId() {
        return batimentId;
    }

    public void setBatimentId(Long batimentId) {
        this.batimentId = batimentId;
    }

    public String getSdeId() {
        return sdeId;
    }

    public void setSdeId(String sdeId) {
        this.sdeId = sdeId;
    }

    public Short getQ1Ordre() {
        return q1Ordre;
    }

    public void setQ1Ordre(Short q1Ordre) {
        this.q1Ordre = q1Ordre;
    }

    public String getQ2Prenom() {
        return q2Prenom;
    }

    public void setQ2Prenom(String q2Prenom) {
        this.q2Prenom = q2Prenom;
    }

    public String getQ3Nom() {
        return q3Nom;
    }

    public void setQ3Nom(String q3Nom) {
        this.q3Nom = q3Nom;
    }

    public Short getQ4Sexe() {
        return q4Sexe;
    }

    public void setQ4Sexe(Short q4Sexe) {
        this.q4Sexe = q4Sexe;
    }

    public Short getQ5Statut() {
        return q5Statut;
    }

    public void setQ5Statut(Short q5Statut) {
        this.q5Statut = q5Statut;
    }

    public Short getQ6EtaitMembreMenage() {
        return q6EtaitMembreMenage;
    }

    public void setQ6EtaitMembreMenage(Short q6EtaitMembreMenage) {
        this.q6EtaitMembreMenage = q6EtaitMembreMenage;
    }

    public Short getQ7DateQuitterMenageJour() {
        return q7DateQuitterMenageJour;
    }

    public void setQ7DateQuitterMenageJour(Short q7DateQuitterMenageJour) {
        this.q7DateQuitterMenageJour = q7DateQuitterMenageJour;
    }

    public Short getQADateQuitterMenageMois() {
        return qADateQuitterMenageMois;
    }

    public void setQADateQuitterMenageMois(Short qADateQuitterMenageMois) {
        this.qADateQuitterMenageMois = qADateQuitterMenageMois;
    }

    public String getQADateQuitterMenageAnnee() {
        return qADateQuitterMenageAnnee;
    }

    public void setQADateQuitterMenageAnnee(String qADateQuitterMenageAnnee) {
        this.qADateQuitterMenageAnnee = qADateQuitterMenageAnnee;
    }

    public Short getQ8DateNaissanceJour() {
        return q8DateNaissanceJour;
    }

    public void setQ8DateNaissanceJour(Short q8DateNaissanceJour) {
        this.q8DateNaissanceJour = q8DateNaissanceJour;
    }

    public Short getQ8DateNaissanceMois() {
        return q8DateNaissanceMois;
    }

    public void setQ8DateNaissanceMois(Short q8DateNaissanceMois) {
        this.q8DateNaissanceMois = q8DateNaissanceMois;
    }

    public String getQ8DateNaissanceAnnee() {
        return q8DateNaissanceAnnee;
    }

    public void setQ8DateNaissanceAnnee(String q8DateNaissanceAnnee) {
        this.q8DateNaissanceAnnee = q8DateNaissanceAnnee;
    }

    public Integer getQ9Age() {
        return q9Age;
    }

    public void setQ9Age(Integer q9Age) {
        this.q9Age = q9Age;
    }

    public Short getQ10RelationAvecChefMenage() {
        return q10RelationAvecChefMenage;
    }

    public void setQ10RelationAvecChefMenage(Short q10RelationAvecChefMenage) {
        this.q10RelationAvecChefMenage = q10RelationAvecChefMenage;
    }

    public Short getQ11Nationalite() {
        return q11Nationalite;
    }

    public void setQ11Nationalite(Short q11Nationalite) {
        this.q11Nationalite = q11Nationalite;
    }

    public String getQ11PaysNationalite() {
        return q11PaysNationalite;
    }

    public void setQ11PaysNationalite(String q11PaysNationalite) {
        this.q11PaysNationalite = q11PaysNationalite;
    }

    public Short getQ12NiveauAcademique() {
        return q12NiveauAcademique;
    }

    public void setQ12NiveauAcademique(Short q12NiveauAcademique) {
        this.q12NiveauAcademique = q12NiveauAcademique;
    }

    public Short getQ13StatutMatrimonial() {
        return q13StatutMatrimonial;
    }

    public void setQ13StatutMatrimonial(Short q13StatutMatrimonial) {
        this.q13StatutMatrimonial = q13StatutMatrimonial;
    }

    public Short getStatut() {
        return statut;
    }

    public void setStatut(Short statut) {
        this.statut = statut;
    }

    public Boolean getIsValidated() {
        return isValidated;
    }

    public void setIsValidated(Boolean isValidated) {
        this.isValidated = isValidated;
    }

    public Boolean getIsFieldAllFilled() {
        return isFieldAllFilled;
    }

    public void setIsFieldAllFilled(Boolean isFieldAllFilled) {
        this.isFieldAllFilled = isFieldAllFilled;
    }

    public String getDateDebutCollecte() {
        return dateDebutCollecte;
    }

    public void setDateDebutCollecte(String dateDebutCollecte) {
        this.dateDebutCollecte = dateDebutCollecte;
    }

    public String getDateFinCollecte() {
        return dateFinCollecte;
    }

    public void setDateFinCollecte(String dateFinCollecte) {
        this.dateFinCollecte = dateFinCollecte;
    }

    public Integer getDureeSaisie() {
        return dureeSaisie;
    }

    public void setDureeSaisie(Integer dureeSaisie) {
        this.dureeSaisie = dureeSaisie;
    }

    public Boolean getIsContreEnqueteMade() {
        return isContreEnqueteMade;
    }

    public void setIsContreEnqueteMade(Boolean isContreEnqueteMade) {
        this.isContreEnqueteMade = isContreEnqueteMade;
    }

    public String getCodeAgentRecenceur() {
        return codeAgentRecenceur;
    }

    public void setCodeAgentRecenceur(String codeAgentRecenceur) {
        this.codeAgentRecenceur = codeAgentRecenceur;
    }
    //endregion
}
