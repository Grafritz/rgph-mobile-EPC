package ht.ihsi.rgph.mobile.epc.Managers;

import java.util.List;

import ht.ihsi.rgph.mobile.epc.Exceptions.ManagerException;
import ht.ihsi.rgph.mobile.epc.Models.BatimentModel;
import ht.ihsi.rgph.mobile.epc.Models.IndividuModel;
import ht.ihsi.rgph.mobile.epc.Models.LogementModel;
import ht.ihsi.rgph.mobile.epc.Models.MenageModel;
import ht.ihsi.rgph.mobile.epc.Models.RowDataListModel;
import ht.ihsi.rgph.mobile.epc.Utilities.Shared_Preferences;


/**
 * Created by JFDuverseau on 09/28/2017.
 */
 public interface QueryRecordMngr {

    boolean isRecAlreadyExist(String rec)throws ManagerException;

    List<RowDataListModel> searchListBatByStatus(Short status) throws ManagerException;

    List<RowDataListModel> searchListLogByTypeAndBatAndStat(int type, long batId, Short status) throws ManagerException;

    List<RowDataListModel> searchListMenageByLog(long logId, Short satut)  throws ManagerException;

    List<RowDataListModel> searcListhMenageByStaAndLog(Short status, long logId)  throws ManagerException;

    List<RowDataListModel> searchListIndByMenageAndStatut(Short statut, long menageId) throws ManagerException;

    List<RowDataListModel> searchListIndividu_ByLogement(long logementId) throws ManagerException;

    List<RowDataListModel> searchListIndividu_ByMenage(long menageId) throws ManagerException;

    List<RowDataListModel> searchListMenage_ByLogement(long logementId) throws ManagerException;

    List<RowDataListModel> searchListLogement_ByBatiment_ByCategLogement(long batimentId, int categLogement) throws ManagerException;

    List<RowDataListModel> searchListIndByStaAndLog(Short status, long logId)  throws ManagerException;

    // POUR CONTRAINTE
    IndividuModel searchIndividu_ByNoOrdre_ByIdLienDeParente_ByIdMenage(int NoOrdre, int IdLienDeParente, long IdMenage) throws ManagerException;
    IndividuModel searchIndividu_ByNoOrdre_ByIdLienDeParente_ByIdLogement(int NoOrdre, int IdLienDeParente, long IdMenage) throws ManagerException;
    IndividuModel searchIndividu_ByNoOrdre_ByIdLogement(int noOrdre, long idLogement) throws ManagerException;
    IndividuModel searchIndividu_ByNoOrdre_ByIdMenage(int NoOrdre, long IdMenage, boolean statut) throws ManagerException;

    MenageModel searchMenage_ByNoOrdre_ByIdLogement(int NoOrdre, long idLogement) throws ManagerException;

    LogementModel searchLogementByNoOrdreByTypeLogByIdBatiment(int NoOrdre, int CategLogement, long IdBatiment) throws ManagerException;

    /**
     * Return the number of batiments by status
     * @param status the status of the batiment
     * @return long
     */
    long countBatimentByStatus(int status);

    int countBatimentBySDE(String sde);

    /**
     * Return the number of logements by Batiment, type and the status.
     *
     * @param batId  the id of batiment
     * @param status the status of the logement
     * @param type   the type of a logement
     * @return long
     */
    long countLogByBatStatusAndType(long batId, int status, int type) ;

    /**
     * Return the number of logements by batiment and type.
     *
     * @param batId the id of batiment.
     * @param type  the type of logement.
     * @return long
     */
    long countLogByBatAndType(long batId, int type);

    long countLogByBat(long batId);

    long countLogement_ByBatiment_byTypeLog_ByStatus(long batId, int typelogement, int statutFormulaire);

    long countLogement_AllFilled_ByBatiment_byTypeLog_ByStatus(long batId, int typelogement, int statutFormulaire, boolean isFillAllField);

    /**
     * Return the number of individu by type of logement.
     *
     * @param logId the id of a logememt.
     * @return int
     */
    long countIndByLog(long logId);

    long countIndividus_AllFilled_ByLogement_ByStatus(long logId, int statutFormulaire, boolean isFillAllField);

    /**
     * Return the number of individu by type of logement.
     *
     * @param logId the id of a logememt.
     * @param status the status of a logememt.
     * @return int
     */
    long countIndByLogByStatus(long logId, int status);

    /**
     * Return the number of individu by type of Menage.
     *
     * @param menageId the id of a Menage.
     * @return int
     */
    long countIndByMenage(long menageId);

    long countIndividus_AllFilled_ByMenage_ByStatus(long menageId, int statutFormulaire, boolean isFillAllField);

   /**
    * Return the number of individu by type of Menage.
    *
    * @param menageId the id of a Menage.
    * @param status the status of a Menage
    * @return int
    */
   long countIndByMenageByStatus(long menageId, int status);

    /**
     * Return the number of menages by status of the menage and by logement.
     *
     * @param status the status of the menage
     * @param logId  the id of the logement.
     * @return long
     */
    long countMenageByStatusAndLog(int status, long logId);

    /**
     * Return the number of menages by logement.
     *
     * @param logId the id of the logement
     * @return long
     */
    long countMenageByLog(long logId);

    long countMenage_AllFilled_ByLogement_ByStatus(long logId, int statutFormulaire, boolean isFillAllField);

    /**
     * Return the list of Batiments by status.
     *
     * @param status the status of a batiment
     * @return List<BatimentModel>
     * @throws ManagerException
     */
     List<BatimentModel> searchBatByStatus(int status) throws ManagerException;

    /**
     * Get a batiment by its id.
     *
     * @param batId the id of batiment.
     * @return BatimentModel
     * @throws ManagerException
     */
     BatimentModel getBatById(long batId) throws ManagerException;

    /**
     * Return the list of logements by type, batiment and by status.
     *
     * @param type   the type of the logement
     * @param batId  the Id of the batimenet
     * @param status the status of the logement
     * @return List<LogementModel>
     * @throws ManagerException
     */
     List<LogementModel> searchLogByTypeAndBatAndStat(boolean type, long batId, int status) throws ManagerException;

    /**
     * Get a logement by its id.
     *
     * @param logId the id of a logement.
     * @return LogementModel
     * @throws ManagerException
     */
     LogementModel getLogById(long logId) throws ManagerException;
     MenageModel getMenageById(long menageId) throws ManagerException;

    /**
     * \
     * Return the list of menages by logement.
     *
     * @param logId the id of the logement.
     * @return List<MenageModel>
     * @throws ManagerException
     */
     List<MenageModel> searchMenageByLog(long logId) throws ManagerException;


    /**
     * Return the list of menages by logement and by status
     *
     * @param status the status of the menage.
     * @param logId  the id of the logement
     * @return List<MenageModel>
     * @throws ManagerException
     */
     List<MenageModel> searchMenageByStaAndLog(int status, long logId) throws ManagerException;

    /**
     * Return the list of individus in a menage.
     *
     * @param menageId the id of a menage.
     * @return List<IndividuModel>
     * @throws ManagerException
     */
     List<IndividuModel> searchIndByMenage(long menageId) throws ManagerException;

    /**
     * Get an individu by menage
     *
     * @param indId The id of an individu
     * @return IndividuModel
     * @throws ManagerException
     */
     IndividuModel getIndById(long indId) throws ManagerException;

    /**
     * Return the list of individus by status and by logement
     *
     * @param status The status of an individu
     * @param logId  The id of a logement
     * @return List<IndividuModel>
     * @throws ManagerException
     */
    List<IndividuModel> searchIndByStaAndLog(int status, long logId) throws ManagerException;

    void closeDbConnections();

    int countAllDepartement();


    List<RowDataListModel> searchListProfilUser(Shared_Preferences SPref) throws ManagerException;

}
