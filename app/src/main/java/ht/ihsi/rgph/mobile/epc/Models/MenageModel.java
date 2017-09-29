package ht.ihsi.rgph.mobile.epc.Models;

import ht.ihsi.rgph.mobile.epc.Backend.Entities.MenageDao;
import ht.ihsi.rgph.mobile.epc.Constant.Constant;
import ht.ihsi.rgph.mobile.epc.Exceptions.TextEmptyException;
import ht.ihsi.rgph.mobile.epc.Managers.QueryRecordMngr;
import ht.ihsi.rgph.mobile.epc.Utilities.Tools;

/**
 * Created by JFDuverseau on 09/26/2017.
 */
public class MenageModel extends BaseModel{

    //region ATTIBUTS
    private Long menageId;
    private Long logeId;
    private Long batimentId;
    private String sdeId;
    private Short qm1NoOrdre;
    private Short qm11TotalIndividuVivant;
    private Short qm22AncienMembre;
    private Short qm22TotalAncienMembre;
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
    private String qm4ModeAprobEauBoireEtUsageCourant;
    private String qm5SrcEnergieCuison1Et2;
    private String qm9NbrAppareilsEtAnimaux;
    private String qm10TotalDomestiqueGaconEtFille;
    private String qm11CallFormListeIndividu;
    private String callFormulaireEmigre;
    private String callFormulaireDeces;
    private String callFormulaireIndividuMenage;
    //endregion

    //region MODEL OBJET
    public static QueryRecordMngr queryRecordMngr;
    private BatimentModel objBatiment;
    private LogementModel objLogement;
    //endregion

    //region CONSTRUCTEURS
    public MenageModel() {
        BlankData();
    }

    private void BlankData() {
        menageId = Long.valueOf(0);
        batimentId = Long.valueOf(0);
        logeId = Long.valueOf(0);
        qm11TotalIndividuVivant = 0;
    }
    //endregion

    //region MenageModel getters and setters
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

    public Short getQm1NoOrdre() {
        return qm1NoOrdre;
    }

    public void setQm1NoOrdre(Short qm1NoOrdre) {
        this.qm1NoOrdre = qm1NoOrdre;
    }

    public Short getQm11TotalIndividuVivant() {
        return qm11TotalIndividuVivant;
    }

    public void setQm11TotalIndividuVivant(Short qm11TotalIndividuVivant) {
        this.qm11TotalIndividuVivant = qm11TotalIndividuVivant;
    }

    public Short getQm22AncienMembre() {
        return qm22AncienMembre;
    }

    public void setQm22AncienMembre(Short qm22AncienMembre) {
        this.qm22AncienMembre = qm22AncienMembre;
    }

    public Short getQm22TotalAncienMembre() {
        return qm22TotalAncienMembre;
    }

    public void setQm22TotalAncienMembre(Short qm22TotalAncienMembre) {
        this.qm22TotalAncienMembre = qm22TotalAncienMembre;
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

    // region |-| GETTER SETTER SYSTEME |-|

    public String getQm11CallFormListeIndividu() {
        return qm11CallFormListeIndividu;
    }
    public void setQm11CallFormListeIndividu(String qm11CallFormListeIndividu) {
        this.qm11CallFormListeIndividu = qm11CallFormListeIndividu;
    }
    public String getCallFormulaireEmigre() {
        return callFormulaireEmigre;
    }
    public void setCallFormulaireEmigre(String callFormulaireEmigre) {
        this.callFormulaireEmigre = callFormulaireEmigre;
    }
    public String getCallFormulaireDeces() {
        return callFormulaireDeces;
    }
    public void setCallFormulaireDeces(String callFormulaireDeces) {
        this.callFormulaireDeces = callFormulaireDeces;
    }
    public String getCallFormulaireIndividuMenage() {
        return callFormulaireIndividuMenage;
    }
    public void setCallFormulaireIndividuMenage(String callFormulaireIndividuMenage) {
        this.callFormulaireIndividuMenage = callFormulaireIndividuMenage;
    }
    //endregion

    //region Model getters and setters
    public BatimentModel getObjBatiment() {
        return objBatiment;
    }

    public void setObjBatiment(BatimentModel objBatiment) {
        this.objBatiment = objBatiment;
    }

    public LogementModel getObjLogement() {
        return objLogement;
    }

    public void setObjLogement(LogementModel objLogement) {
        this.objLogement = objLogement;
    }
//endregion

    //region METHODES
    public static String Check_ContrainteSautChampsValeur( String nomChamps, MenageModel menageModel, Long iDKeys, Object dataBase)  throws TextEmptyException {
        try{
            String QSuivant = "";

            return QSuivant;
        } catch (Exception ex){
            throw ex;
        }
    }
    //endregion
}
