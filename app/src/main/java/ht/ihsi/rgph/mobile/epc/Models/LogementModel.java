package ht.ihsi.rgph.mobile.epc.Models;

import ht.ihsi.rgph.mobile.epc.Exceptions.TextEmptyException;
import ht.ihsi.rgph.mobile.epc.Managers.CURecordMngr;
import ht.ihsi.rgph.mobile.epc.Managers.FormDataMngr;
import ht.ihsi.rgph.mobile.epc.Managers.QueryRecordMngr;

/**
 * Created by JFDuverseau on 09/26/2017.
 */
public class LogementModel extends BaseModel{

    //region ATTRIBUTS
    private Long logeId;
    private Long batimentId;
    private String sdeId;
    private Short qlin1NumeroOrdre;
    private Short qlin3StatutOccupation;
    private Short qlin2TypeLogement;
    private Short qlin4NbreIndividuDepense;
    private Short qlin5NbreTotalMenage;
    private Short statut;
    private Boolean isValidated;
    private Boolean isFieldAllFilled;
    private String dateDebutCollecte;
    private String dateFinCollecte;
    private Integer dureeSaisie;
    private Boolean isContreEnqueteMade;
    private Short nbrTentative;
    private String codeAgentRecenceur;
    //endregion

    //region VARIABLES SYSTEME
    public String qlc1bTotalGarconEtFille;
    public String qlin6NombrePieceETChambreACoucher;
    private String callFormulaireIndividuLojCol;
    private String callFormulaireMenage;
    private BatimentModel objBatiment;
    public static QueryRecordMngr queryRecordMngr;
    public static FormDataMngr formDataMngr;
    public static CURecordMngr cuRecordMngr;
    //endregion

    //region CONSTRUCTEURS
    public LogementModel() {
        BlankData();
    }

    private void BlankData() {
        this.logeId = Long.valueOf(0);
        this.batimentId = Long.valueOf(0);
        objBatiment = null;
    }
    //endregion

    // region |-| GETTER SETTER SYSTEME |-|

    //endregion

    //region LogementModel getters and setters
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

    public Short getQlin1NumeroOrdre() {
        return qlin1NumeroOrdre;
    }

    public void setQlin1NumeroOrdre(Short qlin1NumeroOrdre) {
        this.qlin1NumeroOrdre = qlin1NumeroOrdre;
    }

    public Short getQlin3StatutOccupation() {
        return qlin3StatutOccupation;
    }

    public void setQlin3StatutOccupation(Short qlin3StatutOccupation) {
        this.qlin3StatutOccupation = qlin3StatutOccupation;
    }

    public Short getQlin2TypeLogement() {
        return qlin2TypeLogement;
    }

    public void setQlin2TypeLogement(Short qlin2TypeLogement) {
        this.qlin2TypeLogement = qlin2TypeLogement;
    }

    public Short getQlin4NbreIndividuDepense() {
        return qlin4NbreIndividuDepense;
    }

    public void setQlin4NbreIndividuDepense(Short qlin4NbreIndividuDepense) {
        this.qlin4NbreIndividuDepense = qlin4NbreIndividuDepense;
    }

    public Short getQlin5NbreTotalMenage() {
        return qlin5NbreTotalMenage;
    }

    public void setQlin5NbreTotalMenage(Short qlin5NbreTotalMenage) {
        this.qlin5NbreTotalMenage = qlin5NbreTotalMenage;
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

    public Short getNbrTentative() {
        return nbrTentative;
    }

    public void setNbrTentative(Short nbrTentative) {
        this.nbrTentative = nbrTentative;
    }

    public String getCodeAgentRecenceur() {
        return codeAgentRecenceur;
    }

    public void setCodeAgentRecenceur(String codeAgentRecenceur) {
        this.codeAgentRecenceur = codeAgentRecenceur;
    }
    //endregion

    //region Model getters and setters

    public String getCallFormulaireIndividuLojCol() {
        return callFormulaireIndividuLojCol;
    }
    public void setCallFormulaireIndividuLojCol(String callFormulaireIndividuLojCol) {
        this.callFormulaireIndividuLojCol = callFormulaireIndividuLojCol;
    }
    public String getCallFormulaireMenage() {
        return callFormulaireMenage;
    }
    public void setCallFormulaireMenage(String callFormulaireMenage) {
        this.callFormulaireMenage = callFormulaireMenage;
    }

    public BatimentModel getObjBatiment() {
        return objBatiment;
    }

    public void setObjBatiment(BatimentModel objBatiment) {
        this.objBatiment = objBatiment;
    }
    //endregion

    //region METHODES Contrainte Saut Champs Valeur
    public static String Check_ContrainteSautChampsValeur( String nomChamps, LogementModel logementModel, Long iDKeys, Object dataBase)  throws TextEmptyException {
        try{
            String QSuivant = "";
            return QSuivant;
        } catch (Exception ex){
            throw ex;
        }
    }
    //endregion


}

