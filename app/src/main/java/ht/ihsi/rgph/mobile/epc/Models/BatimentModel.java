package ht.ihsi.rgph.mobile.epc.Models;

import ht.ihsi.rgph.mobile.epc.Exceptions.TextEmptyException;
import ht.ihsi.rgph.mobile.epc.Managers.QueryRecordMngr;

/**
 * Created by JFDuverseau on 09/26/2017.
 */
public class BatimentModel extends BaseModel {

    //region VARIABLES
    private Long batimentId = Long.valueOf(0);
    private String deptId;
    private String comId;
    private String vqseId;
    private String sdeId;
    private Short zone;
    private String disctrictId;
    private String qhabitation;
    private String qlocalite;
    private String qadresse;
    private String qrec;
    private String qepc;
    private Short qb1Type;
    private Short qb2StatutOccupation;
    private Short qb3NbreLogeIndividuel;
    private Short statut;
    private String dateEnvoi;
    private Boolean isValidated;
    private Boolean isSynchroToAppSup;
    private Boolean isSynchroToCentrale;
    private String dateDebutCollecte;
    private String dateFinCollecte;
    private Integer dureeSaisie;
    private Boolean isFieldAllFilled;
    private Boolean isContreEnqueteMade;
    private String latitude;
    private String longitude;
    private String codeAgentRecenceur;

    private String callFormulaireLogementCollectif;
    private String callFormulaireLogementEndividyel;
    public static QueryRecordMngr queryRecordMngr;

    //endregion

    //region CONSTRUCTEURS
    public BatimentModel() {
        BlankData();
    }

    private void BlankData() {
        batimentId = Long.valueOf(0);
    }
    //endregion

    //region BatimentModel getters and setters
    public Long getBatimentId() {
        return batimentId;
    }

    public void setBatimentId(Long batimentId) {
        this.batimentId = batimentId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getVqseId() {
        return vqseId;
    }

    public void setVqseId(String vqseId) {
        this.vqseId = vqseId;
    }

    public String getSdeId() {
        return sdeId;
    }

    public void setSdeId(String sdeId) {
        this.sdeId = sdeId;
    }

    public Short getZone() {
        return zone;
    }

    public void setZone(Short zone) {
        this.zone = zone;
    }

    public String getDisctrictId() {
        return disctrictId;
    }

    public void setDisctrictId(String disctrictId) {
        this.disctrictId = disctrictId;
    }

    public String getQhabitation() {
        return qhabitation;
    }

    public void setQhabitation(String qhabitation) {
        this.qhabitation = qhabitation;
    }

    public String getQlocalite() {
        return qlocalite;
    }

    public void setQlocalite(String qlocalite) {
        this.qlocalite = qlocalite;
    }

    public String getQadresse() {
        return qadresse;
    }

    public void setQadresse(String qadresse) {
        this.qadresse = qadresse;
    }

    public String getQrec() {
        return qrec;
    }

    public void setQrec(String qrec) {
        this.qrec = qrec;
    }

    public String getQepc() {
        return qepc;
    }

    public void setQepc(String qepc) {
        this.qepc = qepc;
    }

    public Short getQb1Type() {
        return qb1Type;
    }

    public void setQb1Type(Short qb1Type) {
        this.qb1Type = qb1Type;
    }

    public Short getQb2StatutOccupation() {
        return qb2StatutOccupation;
    }

    public void setQb2StatutOccupation(Short qb2StatutOccupation) {
        this.qb2StatutOccupation = qb2StatutOccupation;
    }

    public Short getQb3NbreLogeIndividuel() {
        return qb3NbreLogeIndividuel;
    }

    public void setQb3NbreLogeIndividuel(Short qb3NbreLogeIndividuel) {
        this.qb3NbreLogeIndividuel = qb3NbreLogeIndividuel;
    }

    public Short getStatut() {
        return statut;
    }

    public void setStatut(Short statut) {
        this.statut = statut;
    }

    public String getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(String dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public Boolean getIsValidated() {
        return isValidated;
    }

    public void setIsValidated(Boolean isValidated) {
        this.isValidated = isValidated;
    }

    public Boolean getIsSynchroToAppSup() {
        return isSynchroToAppSup;
    }

    public void setIsSynchroToAppSup(Boolean isSynchroToAppSup) {
        this.isSynchroToAppSup = isSynchroToAppSup;
    }

    public Boolean getIsSynchroToCentrale() {
        return isSynchroToCentrale;
    }

    public void setIsSynchroToCentrale(Boolean isSynchroToCentrale) {
        this.isSynchroToCentrale = isSynchroToCentrale;
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

    public Boolean getIsFieldAllFilled() {
        return isFieldAllFilled;
    }

    public void setIsFieldAllFilled(Boolean isFieldAllFilled) {
        this.isFieldAllFilled = isFieldAllFilled;
    }

    public Boolean getIsContreEnqueteMade() {
        return isContreEnqueteMade;
    }

    public void setIsContreEnqueteMade(Boolean isContreEnqueteMade) {
        this.isContreEnqueteMade = isContreEnqueteMade;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCodeAgentRecenceur() {
        return codeAgentRecenceur;
    }

    public void setCodeAgentRecenceur(String codeAgentRecenceur) {
        this.codeAgentRecenceur = codeAgentRecenceur;
    }
    //endregion

    //region 2 getters and setters

    public String getCallFormulaireLogementCollectif() {
        return callFormulaireLogementCollectif;
    }
    public void setCallFormulaireLogementCollectif(String callFormulaireLogementCollectif) {
        this.callFormulaireLogementCollectif = callFormulaireLogementCollectif;
    }
    public String getCallFormulaireLogementEndividyel() {
        return callFormulaireLogementEndividyel;
    }
    public void setCallFormulaireLogementEndividyel(String callFormulaireLogementEndividyel) {
        this.callFormulaireLogementEndividyel = callFormulaireLogementEndividyel;
    }

    /*public Short getQb7Utilisation1Mere() {
        return qb7Utilisation1Mere;
    }

    public void setQb7Utilisation1Mere(Short qb7Utilisation1Mere) {
        this.qb7Utilisation1Mere = qb7Utilisation1Mere;
    }

    public Short getQb7Utilisation2Mere() {
        return qb7Utilisation2Mere;
    }

    public void setQb7Utilisation2Mere(Short qb7Utilisation2Mere) {
        this.qb7Utilisation2Mere = qb7Utilisation2Mere;
    }

    public Short getQb7Utilisation1Test() {
        return qb7Utilisation1Test;
    }

    public void setQb7Utilisation1Test(Short qb7Utilisation1Test) {
        this.qb7Utilisation1Test = qb7Utilisation1Test;
    }

    public Short getQb7Utilisation2Test() {
        return qb7Utilisation2Test;
    }

    public void setQb7Utilisation2Test(Short qb7Utilisation2Test) {
        this.qb7Utilisation2Test = qb7Utilisation2Test;
    }*/

   /* public String getQb7Utilisation1() {
        // "GrandeCategorie-SousElement"
        return qb7Utilisation1Mere + "-" + qb7Utilisation1Test;
    }
    public void setQb7Utilisation1(String value) {
        try {
            String[] util = value.split("-"); // GrandeCategorie-SousElement
            String Utilisation1Mere  = util[0]; // GrandeCategorie
            String Utilisation1 = util[1];  // SousElement
            qb7Utilisation1Mere = Short.valueOf(Utilisation1Mere);
            qb7Utilisation1Test = Short.valueOf(Utilisation1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /*public String getQb7Utilisation2() {
        // "GrandeCategorie-SousElement"
        return qb7Utilisation2Mere + "-" + qb7Utilisation2Test;
    }
    public void setQb7Utilisation2(String value) {
        try {
            String[] util = value.split("-"); // GrandeCategorie-SousElement
            String Utilisation2Mere  = util[0]; // GrandeCategorie
            String Utilisation2 = util[1];  // SousElement
            qb7Utilisation2Mere = Short.valueOf(Utilisation2Mere);
            qb7Utilisation2Test = Short.valueOf(Utilisation2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    //public void setFormDataMngr(FormDataMngr formDataMngr) { this.formDataMngr = formDataMngr; }
    //endregion

    //region METHODES
    public static String Check_ContrainteSautChampsValeur(String nomChamps, BatimentModel batimentModel, Long iDKeys, Object dataBase, Boolean ExpulseException)  throws TextEmptyException {
        try{
            String QSuivant = "";
            // B1
            /*if (nomChamps.equalsIgnoreCase(BatimentDao.Properties.Qrec.columnName)){
                if( ExpulseException==true &&  batimentModel.getQrec().trim().equalsIgnoreCase("000") ){
                    throw new TextEmptyException("Ou pa ka ekri 000 (Nimewo sa a pa dwe  000).");
                }

                if (iDKeys <= 0){
                    if( ExpulseException==true &&  IsBatimentExiste_ByRec(batimentModel.getQrec()) ){
                        throw new TextEmptyException("Nimewo REC " + batimentModel.getQrec() + " sa a anrejistre deja. \nNimewo ou ekri a pa bon, gade nimewo ou te ekri avan yo.");
                    }
                }else{
                    if (dataBase != null){
                        BatimentModel b2 = (BatimentModel)dataBase;
                        if ( ExpulseException==true && !b2.getQrec().equalsIgnoreCase( batimentModel.getQrec() ) ) {
                            if ( ExpulseException==true &&  IsBatimentExiste_ByRec(b2.getQrec()) ){
                                throw new TextEmptyException("Nimewo REC " + b2.getQrec() + " sa a anrejistre deja. \nNimewo ou ekri a pa bon, gade nimewo ou te ekri avan yo.");
                            }
                        }
                    }
                }
            }*/
           /*
            if (nomChamps.equalsIgnoreCase(BatimentDao.Properties.Qb6StatutOccupation.columnName)){
                if ( ExpulseException==true &&  batimentModel.getQb6StatutOccupation() == Constant.BATIMAN_TOUJOU_VID_2  ){
                    long NbreLogement_DejaSave = 0;
                    if( ExpulseException==true && batimentModel.getBatimentId() > 0 ){
                        NbreLogement_DejaSave = queryRecordMngr.countLogByBat(batimentModel.getBatimentId());
                        if( ExpulseException==true &&  NbreLogement_DejaSave > 0 ){
                            throw new TextEmptyException("Ou paka chwazi [ "+ Tools.getString_Reponse("" + batimentModel.getQb6StatutOccupation(), BatimentDao.Properties.Qb6StatutOccupation.columnName) +" ]. "
                                    + "\n  paske ou gentan anregistre [" + NbreLogement_DejaSave + "] Lojman pou batiman sa.");
                        }
                    }
                }
            }*/
            /*if (nomChamps.equalsIgnoreCase(BatimentDao.Properties.Qb7Utilisation1.columnName)){
                if ( ExpulseException==true &&  batimentModel.getQb7Utilisation1() == Constant.PA_GEN_LOT_ITILIZASYON  ){
                    throw new TextEmptyException("Si Batiman sa okipe li dwe genyen yon itilizasyon.");
                }
            }*/
            /*if (nomChamps.equalsIgnoreCase(BatimentDao.Properties.Qb7Utilisation2.columnName)){
                // region ITILIZASYON 1 OU ITILIZASYON 2 PA DWE MENM BAGAY
                if ( ExpulseException==true &&  batimentModel.getQb7Utilisation1() >= 10 && batimentModel.getQb7Utilisation1() <= 18  ){
                    if( ExpulseException==true &&  batimentModel.getQb7Utilisation2() >= 10 && batimentModel.getQb7Utilisation2() <= 18   ){
                        throw new TextEmptyException("Yon batiman paka gen de menm prensipal itilizasyon.\n" +
                                "\n -> Ou te chwazi ["+ Tools.getString_Reponse("1", BatimentDao.Properties.Qb7Utilisation1.columnName) +"] deja." +
                                "\n\nSi se yon sèl itilizasyon batiman an genyen,\n Chwazi : [ Pa geyen yon dezièm itilizasyon ]");
                    }
                }
                if ( ExpulseException==true &&  batimentModel.getQb7Utilisation1() >= 20 && batimentModel.getQb7Utilisation1() <= 26  ){
                    if( ExpulseException==true &&  batimentModel.getQb7Utilisation2() >= 20 && batimentModel.getQb7Utilisation2() <= 26   ){
                        throw new TextEmptyException("Yon batiman paka gen de menm prensipal itilizasyon.\n" +
                                "\n -> Ou te chwazi ["+ Tools.getString_Reponse("2", BatimentDao.Properties.Qb7Utilisation1.columnName) +"] deja." +
                                "\n\nSi se yon sèl itilizasyon batiman an genyen,\n Chwazi : [ Pa geyen yon dezièm itilizasyon ]");
                    }
                }
                if ( ExpulseException==true &&  batimentModel.getQb7Utilisation1() >= 30 && batimentModel.getQb7Utilisation1() <= 41  ){
                    if( ExpulseException==true &&  batimentModel.getQb7Utilisation2() >= 30 && batimentModel.getQb7Utilisation2() <= 41   ){
                        throw new TextEmptyException("Yon batiman paka gen de menm prensipal itilizasyon.\n" +
                                "\n -> Ou te chwazi ["+ Tools.getString_Reponse("3", BatimentDao.Properties.Qb7Utilisation1.columnName) +"] deja." +
                                "\n\nSi se yon sèl itilizasyon batiman an genyen,\n Chwazi : [ Pa geyen yon dezièm itilizasyon ]");
                    }
                }
                if ( ExpulseException==true &&  batimentModel.getQb7Utilisation1() == batimentModel.getQb7Utilisation2() ){
                    throw new TextEmptyException("Yon batiman paka gen de menm prensipal itilizasyon.\n" +
                            "Si se yon sèl itilizasyon batiman an genyen,\n\n Chwazi : [ Pa geyen yon dezièm itilizasyon ]");
                }
                //endregion

                // Si la seule utilisation principale (ou les deux utilisations principales) du bâtiment tombe dans les intervalles suivants :
                // 20≥B.7 ≤26 ou 30≥B.7 ≤41, introduire un contrôle permettant d'aller au rapport de l'Agent Recenseur
                if ( batimentModel.getQb7Utilisation1()!= null && batimentModel.getQb7Utilisation1() >= 20 ){
                    if ( batimentModel.getQb7Utilisation2()!=null && batimentModel.getQb7Utilisation2() == Constant.PA_GEN_LOT_ITILIZASYON ) { // SI PA GENYEN YON DEZYEM ITLIZASYON
                        if(  ExpulseException==true &&  batimentModel.getBatimentId() > 0 ){ // VERIFYE SI T GEN YON LOJMAN KI ANREJISTRE DEJA
                            long NbreLogement_DejaSave = 0;
                            NbreLogement_DejaSave = queryRecordMngr.countLogByBat(batimentModel.getBatimentId());
                            if( ExpulseException==true &&  NbreLogement_DejaSave > 0 ){
                                throw new TextEmptyException("Ou paka chwazi [ "+ Tools.getString_Reponse("" + batimentModel.getQb7Utilisation2(), BatimentDao.Properties.Qb7Utilisation1.columnName) +" ]. "
                                        + "\n  paske ou gentan anregistre [" + NbreLogement_DejaSave + "] Lojman pou batiman sa.");
                            }
                        }
                        QSuivant = Constant.FIN;
                    }else  if ( batimentModel.getQb7Utilisation2()!=null && batimentModel.getQb7Utilisation2() >= 20 ) { // SI GEN YON LOT ITLIZASYON
                        if(  ExpulseException==true &&  batimentModel.getBatimentId() > 0 ){ // VERIFYE SI TE GEN YON LOJMAN KI ANREJISTRE DEJA
                            long NbreLogement_DejaSave = 0;
                            NbreLogement_DejaSave = queryRecordMngr.countLogByBat(batimentModel.getBatimentId());
                            if( ExpulseException==true &&  NbreLogement_DejaSave > 0 ){
                                throw new TextEmptyException("Ou paka chwazi [ "+ Tools.getString_Reponse("" + batimentModel.getQb7Utilisation2(), BatimentDao.Properties.Qb7Utilisation1.columnName) +" ]. "
                                        + "\n  paske ou gentan anregistre [" + NbreLogement_DejaSave + "] Lojman pou batiman sa.");
                            }
                        }
                        QSuivant = Constant.FIN;
                    }else  if ( batimentModel.getQb7Utilisation2()!= null && batimentModel.getQb7Utilisation2() <= 18 ){
                        QSuivant ="";
                    }
                }
            }*/
           /* if (nomChamps.equalsIgnoreCase(BatimentDao.Properties.Qb8NbreLogeCollectif.columnName)) {
                if( ExpulseException==true &&  batimentModel.getBatimentId()!=null && batimentModel.getBatimentId() > 0  ) {
                    long NbreLogement_DejaSave = queryRecordMngr.countLogByBatAndType(batimentModel.getBatimentId(), Constant.LOJ_KOLEKTIF);
                    if (batimentModel.getQb8NbreLogeCollectif() < NbreLogement_DejaSave) {
                        throw new TextEmptyException("Ou paka retire nan kantite ke ou te mete a. "
                                + "\n  paske ou gentan anregistre [" + NbreLogement_DejaSave + "] Lojman kolektif deja pou batiman sa.");
                    }
                }
                if( ExpulseException==true && batimentModel.getQb8NbreLogeCollectif() <= 0 ){
                    QSuivant = "B8.2";
                }
            }*/
            /*if (nomChamps.equalsIgnoreCase(BatimentDao.Properties.Qb8NbreLogeIndividuel.columnName)){
                // NbreLogeCollectif OU Qb9NbreLogeIndividuel PA DWE PI PITI KE 1
                if ( ExpulseException==true &&  batimentModel.getQb8NbreLogeCollectif() <= 0 && batimentModel.getQb8NbreLogeIndividuel() <= 0){
                    // Fok yonn nan repons sa yo diferan de « 00 ». verifye enfomasyon an epi korije repons ki pa korek la //
                    throw new TextEmptyException("Ou dwe gen pou pi piti yon lojman kolektif "
                            + (char)13 + "oubyen yon lojman endividyèl.");
                }
                if( ExpulseException==true &&  batimentModel.getBatimentId()!=null && batimentModel.getBatimentId() > 0  ) {
                    long NbreLogement_DejaSave = queryRecordMngr.countLogByBatAndType(batimentModel.getBatimentId(), Constant.LOJ_ENDIVIDYEL);
                    if (ExpulseException == true && batimentModel.getQb8NbreLogeIndividuel() < NbreLogement_DejaSave) {
                        throw new TextEmptyException("Ou paka retire nan kantite ke ou te mete a. "
                                + "\n  paske ou gentan anregistre [" + NbreLogement_DejaSave + "] Lojman endividyèl deja pou batiman sa.");
                    }
                }
                //if( batimentModel.getQb8NbreLogeCollectif() <= 0 && batimentModel.getQb8NbreLogeIndividuel() <= 0 ){
                //    QSuivant = Constant.FIN;
                //}
                if( ExpulseException==true && batimentModel.getQb8NbreLogeIndividuel()!=null && batimentModel.getQb8NbreLogeIndividuel() <= 0 ){
                    QSuivant = Constant.FIN;
                }
            }*/
            return QSuivant;
        } catch (Exception ex){
            throw ex;
        }
    }

    private static boolean IsBatimentExiste_ByRec(String qrec) {
        /*try {
            return queryRecordMngr.isRecAlreadyExist(qrec);
        } catch (ManagerException e) {
            ToastUtility.LogCat("E", "ManagerException: IsBatimentExiste_ByRec() | getMessage:" + e.getMessage() + " /n toString:" + e.toString());
            return true;
        }*/
        return false;
    }


    //endregion
}

