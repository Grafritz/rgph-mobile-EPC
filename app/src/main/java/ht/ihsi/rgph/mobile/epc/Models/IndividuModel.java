package ht.ihsi.rgph.mobile.epc.Models;

import java.util.Calendar;
import java.util.GregorianCalendar;

import ht.ihsi.rgph.mobile.epc.Backend.Entities.IndividuDao;
import ht.ihsi.rgph.mobile.epc.Constant.Constant;
import ht.ihsi.rgph.mobile.epc.Exceptions.ManagerException;
import ht.ihsi.rgph.mobile.epc.Exceptions.TextEmptyException;
import ht.ihsi.rgph.mobile.epc.Managers.QueryRecordMngr;
import ht.ihsi.rgph.mobile.epc.Utilities.ToastUtility;
import ht.ihsi.rgph.mobile.epc.Utilities.Tools;


/**
 * Created by JFDuverseau on 09/26/2017.
 */
public class IndividuModel extends BaseModel{

//region ATTRIBUT
private Long individuId;
    private Long menageId;
    private Long logeId;
    private Long batimentId;
    private String sdeId;
    private Short q1NoOrdre;
    private String qp2APrenom;
    private String qp2BNom;
    private Short qp4Sexe;
    private Short q5EstMembreMenage;
    private Short q6aMembreMenageDepuisQuand;
    private Short q6bDateJour;
    private Short q6bDateMois;
    private String q6bDateAnnee;
    private Short q7DateNaissanceJour;
    private Short q7DateNaissanceMois;
    private String q7DateNaissanceAnnee;
    private Short q8Age;
    private Short q9LienDeParente;
    private Short qp10Nationalite;
    private String qp10PaysNationalite;
    private Short q11NiveauEtude;
    private Short q12StatutMatrimonial;
    private Short statut;
    private Boolean isValidated;
    private Boolean isFieldAllFilled;
    private String dateDebutCollecte;
    private String dateFinCollecte;
    private Integer dureeSaisie;
    private Boolean isContreEnqueteMade;
    private String codeAgentRecenceur;
//endregion

//region VARIABLE SYSTEME
    private String qp5JourMoisAnneeDateNaissance;
    private String qe4ANiveauEtudeETClasse;
    private String qem2MoisAnneeRetour;
    private String qf1NbreEnfantNeVivantGarconEtFille;
    private String qf2NbrEnfantVivantGarconEtFille;
    private String qf3JourMoisAnneeDernierEnfant;
//endregion

    //region MODEL OBJET
    private BatimentModel objBatiment;
    private LogementModel objLogement;
    private MenageModel objMenage;
    public static QueryRecordMngr queryRecordMngr;
    //endregion

    public IndividuModel() {
        this.individuId = Long.valueOf(0);
    }

    // region [ GETTER SETTER SYSTEME ]

    //endregion

    //region [ Model ]
    public MenageModel getObjMenage() {
        return objMenage;
    }

    public void setObjMenage(MenageModel objMenage) {
        this.objMenage = objMenage;
    }

    public LogementModel getObjLogement() {
        return objLogement;
    }

    public void setObjLogement(LogementModel objLogement) {
        this.objLogement = objLogement;
    }

    public BatimentModel getObjBatiment() {
        return objBatiment;
    }

    public void setObjBatiment(BatimentModel objBatiment) {
        this.objBatiment = objBatiment;
    }
    //endregion

    //region [ getters and setters ]
    public Long getIndividuId() {
        return individuId;
    }

    public void setIndividuId(Long individuId) {
        this.individuId = individuId;
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

    public Short getQ1NoOrdre() {
        return q1NoOrdre;
    }

    public void setQ1NoOrdre(Short q1NoOrdre) {
        this.q1NoOrdre = q1NoOrdre;
    }

    public String getQp2APrenom() {
        return qp2APrenom;
    }

    public void setQp2APrenom(String qp2APrenom) {
        this.qp2APrenom = qp2APrenom;
    }

    public String getQp2BNom() {
        return qp2BNom;
    }

    public void setQp2BNom(String qp2BNom) {
        this.qp2BNom = qp2BNom;
    }

    public Short getQp4Sexe() {
        return qp4Sexe;
    }

    public void setQp4Sexe(Short qp4Sexe) {
        this.qp4Sexe = qp4Sexe;
    }

    public Short getQ5EstMembreMenage() {
        return q5EstMembreMenage;
    }

    public void setQ5EstMembreMenage(Short q5EstMembreMenage) {
        this.q5EstMembreMenage = q5EstMembreMenage;
    }

    public Short getQ6aMembreMenageDepuisQuand() {
        return q6aMembreMenageDepuisQuand;
    }

    public void setQ6aMembreMenageDepuisQuand(Short q6aMembreMenageDepuisQuand) {
        this.q6aMembreMenageDepuisQuand = q6aMembreMenageDepuisQuand;
    }

    public Short getQ6bDateJour() {
        return q6bDateJour;
    }

    public void setQ6bDateJour(Short q6bDateJour) {
        this.q6bDateJour = q6bDateJour;
    }

    public Short getQ6bDateMois() {
        return q6bDateMois;
    }

    public void setQ6bDateMois(Short q6bDateMois) {
        this.q6bDateMois = q6bDateMois;
    }

    public String getQ6bDateAnnee() {
        return q6bDateAnnee;
    }

    public void setQ6bDateAnnee(String q6bDateAnnee) {
        this.q6bDateAnnee = q6bDateAnnee;
    }

    public Short getQ7DateNaissanceJour() {
        return q7DateNaissanceJour;
    }

    public void setQ7DateNaissanceJour(Short q7DateNaissanceJour) {
        this.q7DateNaissanceJour = q7DateNaissanceJour;
    }

    public Short getQ7DateNaissanceMois() {
        return q7DateNaissanceMois;
    }

    public void setQ7DateNaissanceMois(Short q7DateNaissanceMois) {
        this.q7DateNaissanceMois = q7DateNaissanceMois;
    }

    public String getQ7DateNaissanceAnnee() {
        return q7DateNaissanceAnnee;
    }

    public void setQ7DateNaissanceAnnee(String q7DateNaissanceAnnee) {
        this.q7DateNaissanceAnnee = q7DateNaissanceAnnee;
    }

    public Short getQ8Age() {
        return q8Age;
    }

    public void setQ8Age(Short q8Age) {
        this.q8Age = q8Age;
    }

    public Short getQ9LienDeParente() {
        return q9LienDeParente;
    }

    public void setQ9LienDeParente(Short q9LienDeParente) {
        this.q9LienDeParente = q9LienDeParente;
    }

    public Short getQp10Nationalite() {
        return qp10Nationalite;
    }

    public void setQp10Nationalite(Short qp10Nationalite) {
        this.qp10Nationalite = qp10Nationalite;
    }

    public String getQp10PaysNationalite() {
        return qp10PaysNationalite;
    }

    public void setQp10PaysNationalite(String qp10PaysNationalite) {
        this.qp10PaysNationalite = qp10PaysNationalite;
    }

    public Short getQ11NiveauEtude() {
        return q11NiveauEtude;
    }

    public void setQ11NiveauEtude(Short q11NiveauEtude) {
        this.q11NiveauEtude = q11NiveauEtude;
    }

    public Short getQ12StatutMatrimonial() {
        return q12StatutMatrimonial;
    }

    public void setQ12StatutMatrimonial(Short q12StatutMatrimonial) {
        this.q12StatutMatrimonial = q12StatutMatrimonial;
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

    //region METHODES
    public static void Check_ContrainteSautChampsValeur(IndividuModel individuModel)  throws TextEmptyException {
        try {

        } catch (Exception ex) {
            throw ex;
        }
    }

    public static String Check_ContrainteSautChampsValeur(String nomChamps, IndividuModel individuModel, Long iDKeys, Object dataBase, Boolean ExpulseException)  throws TextEmptyException  {
        try {
            String QSuivant = "";

            return QSuivant;
        } catch (Exception ex) {
            throw ex;
        }
    }

    //endregion
}

