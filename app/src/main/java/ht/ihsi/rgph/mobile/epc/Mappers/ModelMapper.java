package ht.ihsi.rgph.mobile.epc.Mappers;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ht.ihsi.rgph.mobile.epc.Backend.Entities.AncienMembre;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Batiment;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.BatimentDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.CategorieQuestion;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Commune;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Departement;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Individu;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.IndividuDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Logement;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Menage;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.MenageDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Module;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Pays;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Personnel;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.PersonnelDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Question;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.QuestionModule;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.QuestionReponse;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Vqse;
import ht.ihsi.rgph.mobile.epc.Constant.Constant;
import ht.ihsi.rgph.mobile.epc.Managers.CURecordMngr;
import ht.ihsi.rgph.mobile.epc.Managers.QueryRecordMngr;
import ht.ihsi.rgph.mobile.epc.Managers.QueryRecordMngrImpl;
import ht.ihsi.rgph.mobile.epc.Models.AncienMembreModel;
import ht.ihsi.rgph.mobile.epc.Models.BatimentModel;
import ht.ihsi.rgph.mobile.epc.Models.CategorieQuestionModel;
import ht.ihsi.rgph.mobile.epc.Models.CommuneModel;
import ht.ihsi.rgph.mobile.epc.Models.DepartementModel;
import ht.ihsi.rgph.mobile.epc.Models.IndividuModel;
import ht.ihsi.rgph.mobile.epc.Models.KeyValueModel;
import ht.ihsi.rgph.mobile.epc.Models.LogementModel;
import ht.ihsi.rgph.mobile.epc.Models.MenageModel;
import ht.ihsi.rgph.mobile.epc.Models.ModuleModel;
import ht.ihsi.rgph.mobile.epc.Models.PaysModel;
import ht.ihsi.rgph.mobile.epc.Models.PersonnelModel;
import ht.ihsi.rgph.mobile.epc.Models.QuestionModuleModel;
import ht.ihsi.rgph.mobile.epc.Models.QuestionReponseModel;
import ht.ihsi.rgph.mobile.epc.Models.QuestionsModel;
import ht.ihsi.rgph.mobile.epc.Models.RowDataListModel;
import ht.ihsi.rgph.mobile.epc.Models.VqseModel;
import ht.ihsi.rgph.mobile.epc.Utilities.Shared_Preferences;
import ht.ihsi.rgph.mobile.epc.Utilities.ToastUtility;
import ht.ihsi.rgph.mobile.epc.Utilities.Tools;


/**
 * Created by jadme on 3/23/2016.
 */
public class ModelMapper {
    //region Map To BaseModel

    public static KeyValueModel MapTo(String key, String value) {
        KeyValueModel kvm = new KeyValueModel(key, value);
        return kvm;
    }

    public static List<RowDataListModel> MapToRowsIndividuOnly(List<Individu> inds){
        List<RowDataListModel> result=new ArrayList<>() ;
        if(inds!=null && inds.size()>0) {
            for (Individu ind: inds) {
                RowDataListModel r = new RowDataListModel();
                // BatimentModel bat =
                r.setTitle("#" + ind.getQ1NoOrdre() +" : " + ind.getQp2APrenom()+"  " + ind.getQp2BNom() );
                r.setDesc(/*"<b>Relasyon:</b>" + Tools.getString_Reponse(""+ind.getQp3LienDeParente(), IndividuDao.Properties.Qp3LienDeParente.columnName)*/
                        " | <b>Sèks:</b>" + Tools.getString_Reponse(""+ind.getQp4Sexe(), IndividuDao.Properties.Qp4Sexe.columnName)
                        + " | <b>Fòm ranpli nèt:</b>" + Tools.getString_Reponse(""+ind.getIsFieldAllFilled(), IndividuDao.Properties.IsFieldAllFilled.columnName));
                r.setIsComplete(false);
                r.setIsModuleMenu(false);
                r.setModel(MapToIndividuModel(ind));
                result.add(r);
            }
        }else{
            /*RowDataListModel r = new RowDataListModel();
            r.setTitle("AUCUN ELELEMENT TROUVE!!!");
            r.setDesc("");
            result.add(r);*/
            result = null;
        }
        return result;
    }

    public static List<RowDataListModel> MapToRowsIndividu(List<Individu> inds){
        List<RowDataListModel> result=new ArrayList<>() ;
        if(inds!=null && inds.size()>0) {
            for (Individu ind: inds) {
                RowDataListModel r = new RowDataListModel();
                // BatimentModel bat =
                r.setTitle("#" + ind.getQ1NoOrdre() +" : " + ind.getQp2APrenom()+"  " + ind.getQp2BNom() );
                r.setDesc(/*"<b>Relasyon:</b>" + Tools.getString_Reponse(""+ind.getQp3LienDeParente(), IndividuDao.Properties.Qp3LienDeParente.columnName)*/
                         " | <b>Sèks:</b>" + Tools.getString_Reponse(""+ind.getQp4Sexe(), IndividuDao.Properties.Qp4Sexe.columnName)
                        + " | <b>Fòm ranpli nèt:</b>" + Tools.getString_Reponse(""+ind.getIsFieldAllFilled(), IndividuDao.Properties.IsFieldAllFilled.columnName));
                        //+ "<br />Sde:" + ind.getSdeId() + "/Batiman-" + ind.getBatimentId() + "/Lojman Endividyèl-" + ind.getLogeId() + "/Menaj-" + ind.getMenageId());
                r.setIsComplete(ind.getIsFieldAllFilled());
                r.setIsModuleMenu(false);
                r.setModel(MapToIndividuModel(ind));
                result.add(r);
            }
        }else{
            /*RowDataListModel r = new RowDataListModel();
            r.setTitle("AUCUN ELELEMENT TROUVE!!!");
            r.setDesc("");
            result.add(r);*/
            result = null;
        }
        return result;
    }


    public static List<RowDataListModel> MapToRowsMenage(Context context, List<Menage> menages){
        int statutFormulaire = Constant.STATUT_MODULE_KI_FINI_1;
        boolean isFillAllField = true;
        List<RowDataListModel> result=new ArrayList<>() ;
        if(menages!=null && menages.size()>0) {
            long NbreEmigre = 0;
            long NbreEmigreSave = 0;
            long NbreEmigreF = 0;
            long NbreEmigreG = 0;

            long NbreDeces = 0;
            long NbreDecesSave = 0;
            long NbreDecesF = 0;
            long NbreDecesG = 0;
            long TotalIndividuVivant = 0;
            QueryRecordMngr queryRecordMngr = new QueryRecordMngrImpl(context);
            for (Menage m : menages) {

                /*if( m.getQn1NbreEmigre() != null && m.getQn1NbreEmigre() > 0 ){
                    NbreEmigre = m.getQn1NbreEmigre();
                }
                if( NbreEmigre > 0 ){
                    NbreEmigreSave = queryRecordMngr.countEmigrer_AllFilled_ByMenage_ByStatus(m.getMenageId(), statutFormulaire, isFillAllField);
                }
                if( m.getQd1NbreDecede() != null &&  m.getQd1NbreDecede() > 0 ) {
                    NbreDeces = m.getQd1NbreDecede();
                }
                if( NbreDeces > 0 ){
                    NbreDecesSave = queryRecordMngr.countDeces_AllFilled_ByMenage_ByStatus(m.getMenageId(), statutFormulaire, isFillAllField);
                }*/

                if( m.getQm11TotalIndividuVivant() != null &&  m.getQm11TotalIndividuVivant() > 0 ){
                    TotalIndividuVivant = queryRecordMngr.countIndividus_AllFilled_ByMenage_ByStatus(m.getMenageId(), statutFormulaire, isFillAllField);
                }

                RowDataListModel r = new RowDataListModel();
                r.setTitle("#"+ m.getQm1NoOrdre()+" Menaj");
                r.setDesc("<b> Emigre:</b> "+ NbreEmigreSave +"/" + NbreEmigre
                        +"<b> | Moun mouri:</b> "+ NbreDecesSave +"/" + NbreDeces
                        + " | <b> Moun Vivan:</b>"+ TotalIndividuVivant +"/"+m.getQm11TotalIndividuVivant()
                        + " | <b>Fòm ranpli nèt:</b>" + Tools.getString_Reponse(""+m.getIsFieldAllFilled(), MenageDao.Properties.IsFieldAllFilled.columnName));
                r.setIsComplete(m.getIsFieldAllFilled());
                r.setIsModuleMenu(true);
                r.setModel(MapToMenageModel(m));
                result.add(r);
            }
        }else{
            result = null;
        }
        return result;
    }

    public static List<CommuneModel> MapToCommune(List<Commune> coms) {
        List<CommuneModel> result = new ArrayList<>() ;
        if(coms!=null && coms.size()>0) {
            for (Commune com : coms) {
                CommuneModel r = new CommuneModel();
                r.setComId(com.getComId());
                r.setComNom(com.getComNom());
                r.setDeptId(com.getDeptId());
                result.add(r);
            }
        }
        return result;
    }

    public static List<VqseModel> MapToVqse(List<Vqse> vqses) {
        List<VqseModel> result = new ArrayList<>() ;
        if(vqses!=null && vqses.size()>0) {
            for (Vqse com : vqses) {
                VqseModel r = new VqseModel();
                r.setVqseId(com.getVqseId());
                r.setVqseNom(com.getVqseNom());
                r.setComId(com.getComId());
                result.add(r);
            }
        }
        return result;
    }


    public void SetStatutLogement(QueryRecordMngr queryRecordMngr, CURecordMngr cuRecordMngr, LogementModel logementModel, int typeLogement) {
        try{
            boolean IsStatutLogementFini = true;
            int statutFormulaire = Constant.STATUT_MODULE_KI_FINI_1;
            boolean isFillAllField = true;
            //****************************************************//
            //********** CALCUL POUR LOGEMENT COLLECTIF **********//
            //****************************************************//
            if(typeLogement == Constant.LOJ_KOLEKTIF){
                //*******  CALCUL POUR INDIVIDUS DANS LE LOGEMENT COLLECTIF  ********//
                int Nbre_TotalIndividu = 0;//this.getLogementModel().getQlcTotalIndividus();
                /*if( logementModel.getQlc1TypeLogement() != null && logementModel.getQlc1TypeLogement() <= 5){
                    if ( logementModel.getQlcTotalIndividus() != null && logementModel.getQlcTotalIndividus() > 0) {
                        Nbre_TotalIndividu = logementModel.getQlcTotalIndividus();
                    }
                }*/
                if (Nbre_TotalIndividu > 0) {
                    // On Calcul le nombre d'individu fini et bien remplit
                    long NbreTotalIndividu_FiniEtBienRemplit = queryRecordMngr.countIndividus_AllFilled_ByLogement_ByStatus( logementModel.getLogeId(), statutFormulaire, isFillAllField);
                    if ( Nbre_TotalIndividu != NbreTotalIndividu_FiniEtBienRemplit ){
                        IsStatutLogementFini=false;
                    }
                }
            }else if(typeLogement == Constant.LOJ_ENDIVIDYEL){
                //********* CALCUL POUR LOGEMENT INDIVIDUEL *********//
                //*******  CALCUL POUR MENAGE DANS LE LOGEMENT  ********//
                int nbre_TotalMenage = 0;
                /*if( logementModel.getQlin9NbreTotalMenage() != null ){
                    nbre_TotalMenage = logementModel.getQlin9NbreTotalMenage();
                }
                if ( logementModel.getQlin8NbreIndividuDepense() != null &&
                        logementModel.getQlin8NbreIndividuDepense() == Constant.REPONS_NON_2 ){
                    nbre_TotalMenage = 1;
                }*/
                // On verifie s'il existe de menage dans le logement Individuel
                if( nbre_TotalMenage > 0 ) {
                    long nbreTotalMenage_FiniEtBienRemplit = queryRecordMngr.countMenage_AllFilled_ByLogement_ByStatus(logementModel.getLogeId(), statutFormulaire, isFillAllField);
                    if ( nbre_TotalMenage != nbreTotalMenage_FiniEtBienRemplit ){
                        IsStatutLogementFini=false;
                    }
                }
            }

            // SI TOUT CE PASSE TRES BIEN ON PASSE LE STATUT DU LOGEMENT A FINI\
            if ( IsStatutLogementFini ) {
                LogementModel logModel = logementModel;
                // SI tous les champs du logement sont bien remplit
                if ( logModel.getLogeId() != null &&  logModel.getLogeId() > 0 &&
                        logModel.getIsFieldAllFilled() != null && logModel.getIsFieldAllFilled() ) {
                    logModel.setStatut((short) statutFormulaire);
                    logModel = cuRecordMngr.SaveLogement(logModel.getLogeId(), logementModel, Constant.ACTION_MOFIDIER,"");
                }
            }
        }catch (Exception ex) {
            Log.e(ToastUtility.TAG, "Exception: SetStatutLogement(): ", ex);
            ex.printStackTrace();
        }
    }

    public static List<RowDataListModel> MapToRowsLogement(Context context, List<Logement> loges){
        int statutFormulaire = Constant.STATUT_MODULE_KI_FINI_1;
        boolean isFillAllField = true;
        List<RowDataListModel> result=new ArrayList<>() ;
        if(loges!=null && loges.size()>0) {
            boolean IsStatutLogementFini = true;
            long NbreTotalIndividu_FiniEtBienRemplit = 0;
            long NbreTotalMenage = 0;
            QueryRecordMngr queryRecordMngr = new QueryRecordMngrImpl(context);

            for (Logement log : loges) {
                RowDataListModel r = new RowDataListModel();
                r.setId(log.getLogeId());
                /*if(log.getQlCategLogement() == Constant.LOJ_KOLEKTIF){

                    r.setTitle("#"+ log.getQlin1NumeroOrdre()+" Lojman Kolektif" );
                    String garconEtFille = "";
                    if(log.getQlc1TypeLogement()!= null && log.getQlc1TypeLogement() > 6){
                        garconEtFille = "<br /><b>Kte Gason:</b>" + log.getQlc2bTotalGarcon() + " | <b>Kte Fi:</b>" + log.getQlc2bTotalGarcon();
                    }else{
                        if( log.getQlcTotalIndividus() != null && log.getQlcTotalIndividus() > 0 ){
                            NbreTotalIndividu_FiniEtBienRemplit = queryRecordMngr.countIndividus_AllFilled_ByLogement_ByStatus(log.getLogeId(), statutFormulaire, isFillAllField);
                            if ( log.getQlcTotalIndividus() != NbreTotalIndividu_FiniEtBienRemplit ){
                                IsStatutLogementFini=false;
                            }

                        }
                        garconEtFille = "<br /><b>Kte Moun:</b> "+ NbreTotalIndividu_FiniEtBienRemplit +"/" + log.getQlcTotalIndividus();
                    }
                    r.setDesc("<b>Tip Lojman:</b>" + Tools.getString_Reponse("" + log.getQlc1TypeLogement(), LogementDao.Properties.Qlc1TypeLogement.columnName)
                            + garconEtFille
                            + " | <b>Fòm ranpli nèt:</b>" + Tools.getString_Reponse(""+log.getIsFieldAllFilled(), LogementDao.Properties.IsFieldAllFilled.columnName));
                }else if(log.getQlCategLogement() == Constant.LOJ_ENDIVIDYEL){
                    r.setTitle("#"+ log.getQlin1NumeroOrdre()+" Lojman Endividyèl" );
                    String kteMenaj = "", nbrTentative = "";
                    NbreTotalMenage = queryRecordMngr.countMenage_AllFilled_ByLogement_ByStatus(log.getLogeId(), statutFormulaire, isFillAllField);
                    if( log.getQlin2StatutOccupation() != null && log.getQlin2StatutOccupation() == Constant.LOJMAN_OKIPE_TOUTAN_MEN_MOUN_YO_PA_LA_2   ){
                       if( log.getNbrTentative() != null ) {
                           nbrTentative = " <br /> <b>Nbr Tantativ:</b> " + (log.getNbrTentative()-1);
                       }
                    }
                    if( log.getQlin8NbreIndividuDepense() != null && log.getQlin8NbreIndividuDepense()== Constant.REPONS_WI_1){
                        kteMenaj = "<br /><b>Kte Menaj:</b> "+ NbreTotalMenage +"/"  + log.getQlin9NbreTotalMenage();
                    }else{
                        if( log.getQlin2StatutOccupation() != null && log.getQlin2StatutOccupation() != Constant.LOJMAN_OKIPE_TOUTAN_MEN_MOUN_YO_PA_LA_2   ) {
                            kteMenaj = "<br /><b>Kte Menaj:</b> " + NbreTotalMenage + "/1";
                        }
                    }
                    String typeLogement = "";
                    if( log.getQlin4TypeLogement() != null && log.getQlin4TypeLogement()>0){
                        typeLogement = "<br /><b>Tip Lojman:</b>" + Tools.getString_Reponse("" + log.getQlin4TypeLogement(), LogementDao.Properties.Qlin4TypeLogement.columnName);
                    }
                    r.setDesc("<b>Lojman sa:</b>" + Tools.getString_Reponse("" + log.getQlin2StatutOccupation(), LogementDao.Properties.Qlin2StatutOccupation.columnName)
                            + typeLogement + kteMenaj + nbrTentative
                            + " | <b>Fòm ranpli nèt:</b>" + Tools.getString_Reponse(""+log.getIsFieldAllFilled(), LogementDao.Properties.IsFieldAllFilled.columnName));
                }*/

                r.setIsComplete(log.getIsFieldAllFilled());
                //if( log.getQlin2StatutOccupation() != null && log.getQlin2StatutOccupation() == Constant.LOJMAN_OKIPE_TOUTAN_MEN_MOUN_YO_PA_LA_2
                //        && log.getNbrTentative() != null && log.getNbrTentative() < 4 ){
                    r.setIsModuleMenu(log.getIsFieldAllFilled());
                    r.setIsComplete(log.getIsFieldAllFilled());
               // }else{
                    r.setIsModuleMenu(log.getIsFieldAllFilled());
               // }
                r.setModel(MapToLogementModel(log));
                result.add(r);
            }
        }else{
            result = null;
        }
        return result;
    }

    public static List<RowDataListModel> MapToRows(Context context, List<Batiment> bats){
        int statutFormulaire = Constant.STATUT_MODULE_KI_FINI_1;
        boolean isFillAllField = true;
        List<RowDataListModel> result=new ArrayList<>() ;
        if(bats!=null && bats.size()>0) {
            QueryRecordMngr queryRecordMngr = new QueryRecordMngrImpl(context);
            for (Batiment bat : bats) {
                long LogCol = 0;
                long LogInd = 0;
                /*if( bat.getQb8NbreLogeCollectif()!=null && bat.getQb8NbreLogeCollectif() > 0 ){
                    LogCol = queryRecordMngr.countLogement_AllFilled_ByBatiment_byTypeLog_ByStatus(bat.getBatimentId(), Constant.LOJ_KOLEKTIF, statutFormulaire, isFillAllField);
                }
                if( bat.getQb8NbreLogeIndividuel()!=null && bat.getQb8NbreLogeIndividuel() > 0 ){
                    LogInd = queryRecordMngr.countLogement_AllFilled_ByBatiment_byTypeLog_ByStatus(bat.getBatimentId(), Constant.LOJ_ENDIVIDYEL, statutFormulaire, isFillAllField);
                }*/
                RowDataListModel r = new RowDataListModel();
                r.setId(bat.getBatimentId());

                r.setTitle("<b>#"+ bat.getBatimentId() +" Batiman</b> "+ ( bat.getQepc()!= null ? " | REC: " + bat.getQrec():"")
                        + ""+ ( bat.getQadresse()!= null ? " | <i> " + bat.getQadresse() + "</i>" :"")
                        + ""+ ( bat.getQhabitation()!= null ? " | <b>Bit:</b> " + bat.getQhabitation() :"")
                        + ""+ ( bat.getQlocalite()!= null ? " | <b>Lok:</b> " + bat.getQlocalite() :""));
                r.setDesc( /*( bat.getQb1Etat()!= null ? "<b>Eta:</b> " + Tools.getString_Reponse("" + bat.getQb1Etat(), BatimentDao.Properties.Qb1Etat.columnName):"")
                        + ( bat.getQb2Type()!= null ? "<br /><b>Kalite:</b> " + Tools.getString_Reponse("" + bat.getQb2Type(), BatimentDao.Properties.Qb2Type.columnName):"")
                        + ""+ ( bat.getQb8NbreLogeCollectif()!= null ? "<br /><b>Loj kol:</b> " + LogCol + "/" + bat.getQb8NbreLogeCollectif():"")
                        + ""+ ( bat.getQb8NbreLogeIndividuel()!= null ? " | <b>Loj End:</b> " + LogInd + "/" + bat.getQb8NbreLogeIndividuel():"")
                        + ""+ ( bat.getQb6StatutOccupation()!= null ? "<br /><b>Estati:</b> " + Tools.getString_Reponse("" + bat.getQb6StatutOccupation(), BatimentDao.Properties.Qb6StatutOccupation.columnName):"")
                        + " | <b>Fòm ranpli nèt:</b>" + Tools.getString_Reponse(""+bat.getIsFieldAllFilled(), BatimentDao.Properties.IsFieldAllFilled.columnName)*/
                "");
                r.setIsComplete(bat.getIsFieldAllFilled());
                r.setIsModuleMenu(bat.getIsFieldAllFilled());
                r.setModel(MapToBatimentModel(bat));
                result.add(r);
            }
        }else{
            result = null;
        }
        return result;
    }

    public static PersonnelModel MapTo(Personnel entity) {
        PersonnelModel m = new PersonnelModel();
        m.setPersId(entity.getPersId());
        m.setSdeId(entity.getSdeId());
        m.setNom(entity.getNom());
        m.setPrenom(entity.getPrenom());
        m.setSexe(entity.getSexe());
        m.setNomUtilisateur(entity.getNomUtilisateur());
        m.setMotDePasse(entity.getMotDePasse());
        m.setEmail(entity.getEmail());
        m.setDeptId(entity.getDeptId());
        m.setComId(entity.getComId());
        m.setVqseId(entity.getVqseId());
        m.setZone(entity.getZone());
        m.setCodeDistrict(entity.getCodeDistrict());
        m.setEstActif(entity.getEstActif());
        m.setProfileId(entity.getProfileId());
        return m;
    }

    public static Personnel MapTo(PersonnelModel entity) {
        Personnel m = new Personnel();
        //m.setPersId(entity.getPersId());
        m.setSdeId(entity.getSdeId());
        m.setNom(entity.getNom());
        m.setPrenom(entity.getPrenom());
        m.setSexe(entity.getSexe());
        m.setNomUtilisateur(entity.getNomUtilisateur());
        m.setMotDePasse(entity.getMotDePasse());
        m.setEmail(entity.getEmail());
        m.setDeptId(entity.getDeptId());
        m.setComId(entity.getComId());
        m.setVqseId(entity.getVqseId());
        m.setZone(entity.getZone());
        m.setCodeDistrict(entity.getCodeDistrict());
        m.setEstActif(entity.getEstActif());
        m.setProfileId(entity.getProfileId());
        return m;
    }

    public static CategorieQuestionModel MapTo(CategorieQuestion entity) {
        CategorieQuestionModel m = new CategorieQuestionModel();
        m.setCodeCategorie(entity.getCodeCategorie());
        m.setCategorieQuestion(entity.getCategorieQuestion());
        m.setDetailsCategorie(entity.getDetailsCategorie());
        m.setSousDetailsCategorie(entity.getSousDetailsCategorie());
        return m;
    }

    public static QuestionsModel MapTo(Question entity) {
        QuestionsModel m = new QuestionsModel();
        m.setCodeQuestion(entity.getCodeQuestion());
        m.setLibelle(entity.getLibelle());
        m.setDetailsQuestion(entity.getDetailsQuestion());
        m.setIndicationsQuestion(entity.getIndicationsQuestion());
        m.setCodeCategorie(entity.getCodeCategorie());
        m.setNomChamps(entity.getNomChamps());
        m.setTypeQuestion(entity.getTypeQuestion());
        m.setCaratereAccepte(entity.getCaratereAccepte());
        m.setNbreValeurMinimal(entity.getNbreValeurMinimal());
        m.setNbreCaratereMaximal(entity.getNbreCaratereMaximal());
        m.setContrainteSautChampsValeur(entity.getContrainteSautChampsValeur());
        m.setEstSautReponse(entity.getEstSautReponse());
        m.setqPrecedent(entity.getQPrecedent());
        m.setqSuivant(entity.getQSuivant());
        return m;
    }

   /* public static ReponseModel MapTo(Reponse entity) {
        ReponseModel m = new ReponseModel();
        m.setCodeUniqueReponse(entity.getCodeUniqueReponse());
        m.setCodeReponse(entity.getCodeReponse());
        m.setLibelleReponse(entity.getLibelleReponse());
        return m;
    }*/

    public static QuestionReponseModel MapTo(QuestionReponse entity) {
        QuestionReponseModel m = new QuestionReponseModel();
        m.setCodeQuestion(entity.getCodeQuestion());
        m.setCodeUniqueReponse(entity.getCodeUniqueReponse());
        m.setCodeReponse(entity.getCodeReponse());
        m.setLibelleReponse(entity.getLibelleReponse());
        m.setEstEnfant(entity.getEstEnfant());
        m.setAvoirEnfant(entity.getAvoirEnfant());
        m.setCodeParent(entity.getCodeParent());
        m.setQPrecedent(entity.getQPrecedent());
        m.setQSuivant(entity.getQSuivant());
        return m;
    }

    public static ModuleModel MapTo(Module entity) {
        ModuleModel m = new ModuleModel();
        m.setCodeModule(entity.getCodeModule());
        m.setNomModule(entity.getNomModule());
        m.setTypeModule(entity.getTypeModule());
        m.setDescription(entity.getDescription());
        m.setEstActif(entity.getEstActif());
        return m;
    }

    public static QuestionModuleModel MapTo(QuestionModule entity) {
        QuestionModuleModel m = new QuestionModuleModel();
        m.setOrdre(entity.getOrdre());
        m.setCodeModule(entity.getCodeModule());
        m.setCodeQuestion(entity.getCodeQuestion());
        m.setEstDebut(entity.getEstDebut());
        return m;
    }

    public static List<QuestionReponseModel> MapTo(List<QuestionReponse> questionReponse) {
        List<QuestionReponseModel> result = new ArrayList<QuestionReponseModel>();
        for (QuestionReponse qReponseModel : questionReponse) {
            result.add(MapTo(qReponseModel));
        }
        return result;
    }

   /**/
   public static DepartementModel MapTo(Departement entity){
       DepartementModel m = new DepartementModel();
       m.setDeptId(entity.getDeptId());
       m.setDeptNom(entity.getDeptNom());
       return m;
    }

    public static CommuneModel MapTo(Commune entity) {
        CommuneModel m = new CommuneModel();
        m.setComId(entity.getComId());
        m.setComNom(entity.getComNom());
        m.setDeptId(entity.getDeptId());
        return m;
    }

     public static VqseModel MapTo(Vqse entity) {
         VqseModel m = new VqseModel();
         m.setVqseId(entity.getVqseId());
         m.setVqseNom(entity.getVqseNom());
         m.setComId(entity.getComId());
         return m;
     }

    /*public static DomainEtudeModel MapTo(DomainEtude entitiy){
        m.setcode(entity.getcode());
        m.setnomDomaine(entity.getnomDomaine());
    }

    public static PaysModel MapTo(Pays entitiy){
        m.setcodePays(entity.getcodePays());
        m.setnomPays(entity.getnomPays());
    }*/

    //endregion

    //region Map List<Entity>
    public static List<BatimentModel> MapToBatimentModel(List<Batiment> bats) {
        List<BatimentModel> result = new ArrayList<BatimentModel>();
        for (Batiment bat : bats) {
            result.add(MapToBatimentModel(bat));
        }
        return result;
    }

    public static List<LogementModel> MapToLogementModel(List<Logement> loges) {
        List<LogementModel> result = new ArrayList<LogementModel>();
        for (Logement log : loges) {
            result.add(MapToLogementModel(log));
        }
        return result;
    }

    public static List<MenageModel> MapToMenageModel(List<Menage> menages) {
        List<MenageModel> result = new ArrayList<MenageModel>();
        for (Menage m : menages) {
            result.add(ModelMapper.MapToMenageModel(m));
        }
        return result;
    }


    public static List<IndividuModel> MapToIndividuModel(List<Individu> inds) {
        List<IndividuModel> result = new ArrayList<IndividuModel>();
        for (Individu ind : inds) {
            result.add(MapToIndividuModel(ind));
        }
        return result;
    }

    public static List<PaysModel> MapToPays(List<Pays> payses) {
        List<PaysModel> result = new ArrayList<>() ;
        if(payses!=null && payses.size()>0) {
            for (Pays pays : payses) {
                PaysModel r = new PaysModel();
                r.setCodePays(pays.getCodePays());
                r.setNomPays(pays.getNomPays());
                result.add(r);
            }
        }
        return result;
    }

    public static List<RowDataListModel> MapToRows(Shared_Preferences SPref, List<Personnel> personnelList) {
        List<RowDataListModel> result=new ArrayList<>() ;
        if(personnelList != null && personnelList.size() > 0) {
            for (Personnel personnel : personnelList) {
                RowDataListModel r = new RowDataListModel();
                r.setId(personnel.getPersId());
                r.setTitle("" + personnel.getPrenom() + " " + personnel.getNom().toUpperCase());
                String desc = " <b>SDE :</b> " + personnel.getSdeId()
                        + "<br /><b>Kont:</b> " + personnel.getNomUtilisateur()
                        + " | <b>Pòs:</b> " + Tools.getString_Reponse("" + personnel.getProfileId(), PersonnelDao.Properties.ProfileId.columnName)
                        + " | <b>Estati :</b> " + Tools.getString_Reponse((personnel.getEstActif() ? "1" : "0"), PersonnelDao.Properties.EstActif.columnName);
                r.setDesc(desc);

                r.setIsComplete(true);
                r.setIsModuleMenu(false);
                r.setModel(ModelMapper.MapTo(personnel));

                if (SPref != null) {
                    if (SPref.getProfileId() == Constant.PRIVILEGE_DEVELOPPEUR) {
                        result.add(r);
                    } else {
                        if (SPref.getPersId() == personnel.getPersId()) {
                            result.add(r);
                        } else if (personnel.getProfileId() != 201) {
                            result.add(r);
                        }
                    }
                }
            }
        }else{
        }
        return result;
    }
    //endregion

    //region "Map To EntityModel"
    public static BatimentModel MapToBatimentModel(Batiment entity) {
        BatimentModel bat = new BatimentModel();
        bat.setBatimentId(entity.getBatimentId());
        bat.setDeptId(entity.getDeptId());
        bat.setComId(entity.getComId());
        bat.setVqseId(entity.getVqseId());
        bat.setSdeId(entity.getSdeId());
        bat.setZone(entity.getZone());
        bat.setDisctrictId(entity.getDisctrictId());
        bat.setQhabitation(entity.getQhabitation());
        bat.setQlocalite(entity.getQlocalite());
        bat.setQadresse(entity.getQadresse());
        bat.setQrec(entity.getQrec());
        bat.setQepc(entity.getQepc());
        bat.setQb1Type(entity.getQb1Type());
        bat.setQb2StatutOccupation(entity.getQb2StatutOccupation());
        bat.setQb3NbreLogeIndividuel(entity.getQb3NbreLogeIndividuel());
        bat.setStatut(entity.getStatut());
        bat.setDateEnvoi(entity.getDateEnvoi());
        bat.setIsValidated(entity.getIsValidated());
        bat.setIsSynchroToAppSup(entity.getIsSynchroToAppSup());
        bat.setIsSynchroToCentrale(entity.getIsSynchroToCentrale());
        bat.setDateDebutCollecte(entity.getDateDebutCollecte());
        bat.setDateFinCollecte(entity.getDateFinCollecte());
        bat.setDureeSaisie(entity.getDureeSaisie());
        bat.setIsFieldAllFilled(entity.getIsFieldAllFilled());
        bat.setIsContreEnqueteMade(entity.getIsContreEnqueteMade());
        bat.setLatitude(entity.getLatitude());
        bat.setLongitude(entity.getLongitude());
        bat.setCodeAgentRecenceur(entity.getCodeAgentRecenceur());
        return bat;
    }

    public static LogementModel MapToLogementModel(Logement entity) {
        LogementModel log = new LogementModel();
        log.setLogeId(entity.getLogeId());
        log.setBatimentId(entity.getBatimentId());
        log.setSdeId(entity.getSdeId());
        log.setQlin1NumeroOrdre(entity.getQlin1NumeroOrdre());
        log.setQlin3StatutOccupation(entity.getQlin3StatutOccupation());
        log.setQlin2TypeLogement(entity.getQlin2TypeLogement());
        log.setQlin4NbreIndividuDepense(entity.getQlin4NbreIndividuDepense());
        log.setQlin5NbreTotalMenage(entity.getQlin5NbreTotalMenage());
        log.setStatut(entity.getStatut());
        log.setIsValidated(entity.getIsValidated());
        log.setIsFieldAllFilled(entity.getIsFieldAllFilled());
        log.setDateDebutCollecte(entity.getDateDebutCollecte());
        log.setDateFinCollecte(entity.getDateFinCollecte());
        log.setDureeSaisie(entity.getDureeSaisie());
        log.setIsContreEnqueteMade(entity.getIsContreEnqueteMade());
        log.setNbrTentative(entity.getNbrTentative());
        log.setCodeAgentRecenceur(entity.getCodeAgentRecenceur());
        return log;
    }

    public static MenageModel MapToMenageModel(Menage entity) {
        MenageModel men = new MenageModel();
        men.setMenageId(entity.getMenageId());
        men.setLogeId(entity.getLogeId());
        men.setBatimentId(entity.getBatimentId());
        men.setSdeId(entity.getSdeId());
        men.setQm1NoOrdre(entity.getQm1NoOrdre());
        men.setQm11TotalIndividuVivant(entity.getQm11TotalIndividuVivant());
        men.setQm22AncienMembre(entity.getQm22AncienMembre());
        men.setQm22TotalAncienMembre(entity.getQm22TotalAncienMembre());
        men.setStatut(entity.getStatut());
        men.setIsValidated(entity.getIsValidated());
        men.setIsFieldAllFilled(entity.getIsFieldAllFilled());
        men.setDateDebutCollecte(entity.getDateDebutCollecte());
        men.setDateFinCollecte(entity.getDateFinCollecte());
        men.setDureeSaisie(entity.getDureeSaisie());
        men.setIsContreEnqueteMade(entity.getIsContreEnqueteMade());
        men.setCodeAgentRecenceur(entity.getCodeAgentRecenceur());
        return men;
    }

    public static IndividuModel MapToIndividuModel(Individu entity) {
        IndividuModel ind = new IndividuModel();
        ind.setIndividuId(entity.getIndividuId());
        ind.setMenageId(entity.getMenageId());
        ind.setLogeId(entity.getLogeId());
        ind.setBatimentId(entity.getBatimentId());
        ind.setSdeId(entity.getSdeId());
        ind.setQ1NoOrdre(entity.getQ1NoOrdre());
        ind.setQp2APrenom(entity.getQp2APrenom());
        ind.setQp2BNom(entity.getQp2BNom());
        ind.setQp4Sexe(entity.getQp4Sexe());
        ind.setQ5EstMembreMenage(entity.getQ5EstMembreMenage());
        ind.setQ6aMembreMenageDepuisQuand(entity.getQ6aMembreMenageDepuisQuand());
        ind.setQ6bDateJour(entity.getQ6bDateJour());
        ind.setQ6bDateMois(entity.getQ6bDateMois());
        ind.setQ6bDateAnnee(entity.getQ6bDateAnnee());
        ind.setQ7DateNaissanceJour(entity.getQ7DateNaissanceJour());
        ind.setQ7DateNaissanceMois(entity.getQ7DateNaissanceMois());
        ind.setQ7DateNaissanceAnnee(entity.getQ7DateNaissanceAnnee());
        ind.setQ8Age(entity.getQ8Age());
        ind.setQ9LienDeParente(entity.getQ9LienDeParente());
        ind.setQp10Nationalite(entity.getQp10Nationalite());
        ind.setQp10PaysNationalite(entity.getQp10PaysNationalite());
        ind.setQ11NiveauEtude(entity.getQ11NiveauEtude());
        ind.setQ12StatutMatrimonial(entity.getQ12StatutMatrimonial());
        ind.setStatut(entity.getStatut());
        ind.setIsValidated(entity.getIsValidated());
        ind.setIsFieldAllFilled(entity.getIsFieldAllFilled());
        ind.setDateDebutCollecte(entity.getDateDebutCollecte());
        ind.setDateFinCollecte(entity.getDateFinCollecte());
        ind.setDureeSaisie(entity.getDureeSaisie());
        ind.setIsContreEnqueteMade(entity.getIsContreEnqueteMade());
        ind.setCodeAgentRecenceur(entity.getCodeAgentRecenceur());
        return ind;
    }

    public static AncienMembreModel MapToAncienMembreModel(AncienMembre entity) {
        AncienMembreModel anc = new AncienMembreModel();
        anc.setAncienMembreId(entity.getAncienMembreId());
        anc.setMenageId(entity.getMenageId());
        anc.setLogeId(entity.getLogeId());
        anc.setBatimentId(entity.getBatimentId());
        anc.setSdeId(entity.getSdeId());
        anc.setQ1Ordre(entity.getQ1Ordre());
        anc.setQ2Prenom(entity.getQ2Prenom());
        anc.setQ3Nom(entity.getQ3Nom());
        anc.setQ4Sexe(entity.getQ4Sexe());
        anc.setQ5Statut(entity.getQ5Statut());
        anc.setQ6EtaitMembreMenage(entity.getQ6EtaitMembreMenage());
        anc.setQ7DateQuitterMenageJour(entity.getQ7DateQuitterMenageJour());
        anc.setQADateQuitterMenageMois(entity.getQADateQuitterMenageMois());
        anc.setQADateQuitterMenageAnnee(entity.getQADateQuitterMenageAnnee());
        anc.setQ8DateNaissanceJour(entity.getQ8DateNaissanceJour());
        anc.setQ8DateNaissanceMois(entity.getQ8DateNaissanceMois());
        anc.setQ8DateNaissanceAnnee(entity.getQ8DateNaissanceAnnee());
        anc.setQ9Age(entity.getQ9Age());
        anc.setQ10RelationAvecChefMenage(entity.getQ10RelationAvecChefMenage());
        anc.setQ11Nationalite(entity.getQ11Nationalite());
        anc.setQ11PaysNationalite(entity.getQ11PaysNationalite());
        anc.setQ12NiveauAcademique(entity.getQ12NiveauAcademique());
        anc.setQ13StatutMatrimonial(entity.getQ13StatutMatrimonial());
        anc.setStatut(entity.getStatut());
        anc.setIsValidated(entity.getIsValidated());
        anc.setIsFieldAllFilled(entity.getIsFieldAllFilled());
        anc.setDateDebutCollecte(entity.getDateDebutCollecte());
        anc.setDateFinCollecte(entity.getDateFinCollecte());
        anc.setDureeSaisie(entity.getDureeSaisie());
        anc.setIsContreEnqueteMade(entity.getIsContreEnqueteMade());
        anc.setCodeAgentRecenceur(entity.getCodeAgentRecenceur());
        return anc;
    }
    //endregion

    //region Map To Entity
    public static Batiment MapToBatiment(BatimentModel entity) {
        Batiment bat = new Batiment();
        //bat.setBatimentId(entity.getBatimentId());
        bat.setDeptId(entity.getDeptId());
        bat.setComId(entity.getComId());
        bat.setVqseId(entity.getVqseId());
        bat.setSdeId(entity.getSdeId());
        bat.setZone(entity.getZone());
        bat.setDisctrictId(entity.getDisctrictId());
        bat.setQhabitation(entity.getQhabitation());
        bat.setQlocalite(entity.getQlocalite());
        bat.setQadresse(entity.getQadresse());
        bat.setQrec(entity.getQrec());
        bat.setQepc(entity.getQepc());
        bat.setQb1Type(entity.getQb1Type());
        bat.setQb2StatutOccupation(entity.getQb2StatutOccupation());
        bat.setQb3NbreLogeIndividuel(entity.getQb3NbreLogeIndividuel());
        bat.setStatut(entity.getStatut());
        bat.setDateEnvoi(entity.getDateEnvoi());
        bat.setIsValidated(entity.getIsValidated());
        bat.setIsSynchroToAppSup(entity.getIsSynchroToAppSup());
        bat.setIsSynchroToCentrale(entity.getIsSynchroToCentrale());
        bat.setDateDebutCollecte(entity.getDateDebutCollecte());
        bat.setDateFinCollecte(entity.getDateFinCollecte());
        bat.setDureeSaisie(entity.getDureeSaisie());
        bat.setIsFieldAllFilled(entity.getIsFieldAllFilled());
        bat.setIsContreEnqueteMade(entity.getIsContreEnqueteMade());
        bat.setLatitude(entity.getLatitude());
        bat.setLongitude(entity.getLongitude());
        bat.setCodeAgentRecenceur(entity.getCodeAgentRecenceur());
        return bat;
    }

    public static Logement MapToLogement(LogementModel entity) {
        Logement log = new Logement();
        //log.setLogeId(logement.getLogeId());
        log.setBatimentId(entity.getBatimentId());
        log.setSdeId(entity.getSdeId());
        log.setQlin1NumeroOrdre(entity.getQlin1NumeroOrdre());
        log.setQlin3StatutOccupation(entity.getQlin3StatutOccupation());
        log.setQlin2TypeLogement(entity.getQlin2TypeLogement());
        log.setQlin4NbreIndividuDepense(entity.getQlin4NbreIndividuDepense());
        log.setQlin5NbreTotalMenage(entity.getQlin5NbreTotalMenage());
        log.setStatut(entity.getStatut());
        log.setIsValidated(entity.getIsValidated());
        log.setIsFieldAllFilled(entity.getIsFieldAllFilled());
        log.setDateDebutCollecte(entity.getDateDebutCollecte());
        log.setDateFinCollecte(entity.getDateFinCollecte());
        log.setDureeSaisie(entity.getDureeSaisie());
        log.setIsContreEnqueteMade(entity.getIsContreEnqueteMade());
        log.setNbrTentative(entity.getNbrTentative());
        log.setCodeAgentRecenceur(entity.getCodeAgentRecenceur());
        return log;
    }

    public static Menage MapToMenage(MenageModel entity) {
        Menage men = new Menage();
        //men.setMenageId(menage.getMenageId());
        men.setLogeId(entity.getLogeId());
        men.setBatimentId(entity.getBatimentId());
        men.setSdeId(entity.getSdeId());
        men.setQm1NoOrdre(entity.getQm1NoOrdre());
        men.setQm11TotalIndividuVivant(entity.getQm11TotalIndividuVivant());
        men.setQm22AncienMembre(entity.getQm22AncienMembre());
        men.setQm22TotalAncienMembre(entity.getQm22TotalAncienMembre());
        men.setStatut(entity.getStatut());
        men.setIsValidated(entity.getIsValidated());
        men.setIsFieldAllFilled(entity.getIsFieldAllFilled());
        men.setDateDebutCollecte(entity.getDateDebutCollecte());
        men.setDateFinCollecte(entity.getDateFinCollecte());
        men.setDureeSaisie(entity.getDureeSaisie());
        men.setIsContreEnqueteMade(entity.getIsContreEnqueteMade());
        men.setCodeAgentRecenceur(entity.getCodeAgentRecenceur());
        return men;
    }

    public static AncienMembre MapToAncienMembre(AncienMembreModel entity) {
        AncienMembre anc = new AncienMembre();
        //anc.setAncienMembreId(entity.getAncienMembreId());
        anc.setMenageId(entity.getMenageId());
        anc.setLogeId(entity.getLogeId());
        anc.setBatimentId(entity.getBatimentId());
        anc.setSdeId(entity.getSdeId());
        anc.setQ1Ordre(entity.getQ1Ordre());
        anc.setQ2Prenom(entity.getQ2Prenom());
        anc.setQ3Nom(entity.getQ3Nom());
        anc.setQ4Sexe(entity.getQ4Sexe());
        anc.setQ5Statut(entity.getQ5Statut());
        anc.setQ6EtaitMembreMenage(entity.getQ6EtaitMembreMenage());
        anc.setQ7DateQuitterMenageJour(entity.getQ7DateQuitterMenageJour());
        anc.setQADateQuitterMenageMois(entity.getQADateQuitterMenageMois());
        anc.setQADateQuitterMenageAnnee(entity.getQADateQuitterMenageAnnee());
        anc.setQ8DateNaissanceJour(entity.getQ8DateNaissanceJour());
        anc.setQ8DateNaissanceMois(entity.getQ8DateNaissanceMois());
        anc.setQ8DateNaissanceAnnee(entity.getQ8DateNaissanceAnnee());
        anc.setQ9Age(entity.getQ9Age());
        anc.setQ10RelationAvecChefMenage(entity.getQ10RelationAvecChefMenage());
        anc.setQ11Nationalite(entity.getQ11Nationalite());
        anc.setQ11PaysNationalite(entity.getQ11PaysNationalite());
        anc.setQ12NiveauAcademique(entity.getQ12NiveauAcademique());
        anc.setQ13StatutMatrimonial(entity.getQ13StatutMatrimonial());
        anc.setStatut(entity.getStatut());
        anc.setIsValidated(entity.getIsValidated());
        anc.setIsFieldAllFilled(entity.getIsFieldAllFilled());
        anc.setDateDebutCollecte(entity.getDateDebutCollecte());
        anc.setDateFinCollecte(entity.getDateFinCollecte());
        anc.setDureeSaisie(entity.getDureeSaisie());
        anc.setIsContreEnqueteMade(entity.getIsContreEnqueteMade());
        anc.setCodeAgentRecenceur(entity.getCodeAgentRecenceur());
        return anc;
    }


    public static Individu MapToIndividu(IndividuModel entity) {
        Individu ind = new Individu();
        //ind.setIndividuId(entity.getIndividuId());
        ind.setMenageId(entity.getMenageId());
        ind.setLogeId(entity.getLogeId());
        ind.setBatimentId(entity.getBatimentId());
        ind.setSdeId(entity.getSdeId());
        ind.setQ1NoOrdre(entity.getQ1NoOrdre());
        ind.setQp2APrenom(entity.getQp2APrenom());
        ind.setQp2BNom(entity.getQp2BNom());
        ind.setQp4Sexe(entity.getQp4Sexe());
        ind.setQ5EstMembreMenage(entity.getQ5EstMembreMenage());
        ind.setQ6aMembreMenageDepuisQuand(entity.getQ6aMembreMenageDepuisQuand());
        ind.setQ6bDateJour(entity.getQ6bDateJour());
        ind.setQ6bDateMois(entity.getQ6bDateMois());
        ind.setQ6bDateAnnee(entity.getQ6bDateAnnee());
        ind.setQ7DateNaissanceJour(entity.getQ7DateNaissanceJour());
        ind.setQ7DateNaissanceMois(entity.getQ7DateNaissanceMois());
        ind.setQ7DateNaissanceAnnee(entity.getQ7DateNaissanceAnnee());
        ind.setQ8Age(entity.getQ8Age());
        ind.setQ9LienDeParente(entity.getQ9LienDeParente());
        ind.setQp10Nationalite(entity.getQp10Nationalite());
        ind.setQp10PaysNationalite(entity.getQp10PaysNationalite());
        ind.setQ11NiveauEtude(entity.getQ11NiveauEtude());
        ind.setQ12StatutMatrimonial(entity.getQ12StatutMatrimonial());
        ind.setStatut(entity.getStatut());
        ind.setIsValidated(entity.getIsValidated());
        ind.setIsFieldAllFilled(entity.getIsFieldAllFilled());
        ind.setDateDebutCollecte(entity.getDateDebutCollecte());
        ind.setDateFinCollecte(entity.getDateFinCollecte());
        ind.setDureeSaisie(entity.getDureeSaisie());
        ind.setIsContreEnqueteMade(entity.getIsContreEnqueteMade());
        ind.setCodeAgentRecenceur(entity.getCodeAgentRecenceur());
        return ind;
    }
    //endregion

    public static Shared_Preferences MapToPreferences(Context context, PersonnelModel entity) {
        Shared_Preferences sharedPreferences = new Shared_Preferences(context);
        sharedPreferences.setPersId(entity.getPersId());
        sharedPreferences.setSdeId(entity.getSdeId());
        sharedPreferences.setNom(entity.getNom());
        sharedPreferences.setPrenom(entity.getPrenom());
        sharedPreferences.setPrenomEtNom();
        sharedPreferences.setSexe(entity.getSexe());
        sharedPreferences.setNomUtilisateur(entity.getNomUtilisateur());
        sharedPreferences.setMotDePasse(entity.getMotDePasse());
        sharedPreferences.setEmail(entity.getEmail());
        sharedPreferences.setEstActif(entity.getEstActif());
        sharedPreferences.setProfileId(entity.getProfileId());
        sharedPreferences.setDeptId(entity.getDeptId());
        sharedPreferences.setComId(entity.getComId());
        sharedPreferences.setVqseId(entity.getVqseId());

        sharedPreferences.setZone(entity.getZone());
        sharedPreferences.setCodeDsitri(entity.getCodeDistrict());

        sharedPreferences.setIsConnected(entity.getIsConnected());
        sharedPreferences.setprefLastLogin("");
        return sharedPreferences;
    }//


}// END CLASS
//
