package ht.ihsi.rgph.mobile.epc.Managers;

import android.content.Context;
import android.util.Log;

import java.util.List;

import ht.ihsi.rgph.mobile.epc.Backend.Entities.Batiment;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.BatimentDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Individu;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.IndividuDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Logement;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.LogementDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Menage;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.MenageDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Personnel;
import ht.ihsi.rgph.mobile.epc.Constant.Constant;
import ht.ihsi.rgph.mobile.epc.Exceptions.ManagerException;
import ht.ihsi.rgph.mobile.epc.Mappers.ModelMapper;
import ht.ihsi.rgph.mobile.epc.Models.BatimentModel;
import ht.ihsi.rgph.mobile.epc.Models.IndividuModel;
import ht.ihsi.rgph.mobile.epc.Models.LogementModel;
import ht.ihsi.rgph.mobile.epc.Models.MenageModel;
import ht.ihsi.rgph.mobile.epc.Models.RowDataListModel;
import ht.ihsi.rgph.mobile.epc.Utilities.Shared_Preferences;


/**
 * Created by JFDuverseau on 09/28/2017.
 */
public class QueryRecordMngrImpl extends AbstractDatabaseManager implements QueryRecordMngr {

    private static QueryRecordMngrImpl instance;
    private static Context context;

    public QueryRecordMngrImpl(final Context context) {
        super(context);
        QueryRecordMngrImpl.context = context;
    }

    //region required methods
    public static QueryRecordMngrImpl getInstance(Context context){

        if (instance == null) {
            instance = new QueryRecordMngrImpl(context);
        }

        return instance;
    }

    @Override
    public void closeDbConnections(){
       closeConnections();
        if (instance != null) {
            instance = null;
        }
    }

    @Override
    public int countAllDepartement() {
        Log.i(MANAGERS, "Inside of countAllDepartement!");
        long result=0;
        try {
            openReadableDb();
            result = daoSession.getDepartementDao().queryBuilder().count();
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "<> unable to count All Departement : " + ex.getMessage());
        }
        return (int) result;
    }

    @Override
    public List<RowDataListModel> searchListProfilUser(Shared_Preferences SPref) throws ManagerException {
        Log.i(MANAGERS, "Inside of searchListProfilUser!");
        List<RowDataListModel> result = null;
        try {
            openReadableDb();
            List<Personnel> personnels = daoSession.getPersonnelDao().queryBuilder().list();
            result = ModelMapper.MapToRows(SPref, personnels);
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable to search All  ListProfilUser: "+ex.getMessage());
            throw  new ManagerException("<> unable to search All  ListProfilUser ",ex);
        }
        return result;
    }

    @Override
    public long countBatimentByStatus(int status) {
        Log.i(MANAGERS, "Inside of countBatimentByStatus!");
        long result=0;
        try {
            openReadableDb();
            result=daoSession.getBatimentDao().queryBuilder()
                    .where(BatimentDao.Properties.Statut.eq(status)).count();
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "<> unable to count batiment by status this module" + ex.getMessage());
        }
        return result;
    }

    @Override
    public int countBatimentBySDE(String sdeCode) {
        Log.i(MANAGERS, "Inside of countBatimentBySDE!");
        long result=0;
        try {
            openReadableDb();
            result=daoSession.getBatimentDao().queryBuilder()
                    .where(BatimentDao.Properties.SdeId.eq(sdeCode)).count();
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "<> unable to count batiment by SDE this module" + ex.getMessage());
        }
        return (int) result;
    }
    //endregion

    //region additional managers
    /**
     * Return the number of logements by Batiment, type and the status.
     *
     * @param batId  the id of batiment
     * @param status the status of the logement
     * @param type   the type of a logement
     * @return int
     */
    @Override
    public synchronized long countLogByBatStatusAndType(long batId, int status, int type)  {
        Log.i(MANAGERS, "Inside of countLogByBatStatusAndType!");
        long result=0;
        try {
            openReadableDb();
            result=daoSession.getLogementDao().queryBuilder()
                    .where(LogementDao.Properties.BatimentId.eq(batId))
                    .where(LogementDao.Properties.Statut.eq(status))
                    //.where(LogementDao.Properties.QlCategLogement.eq(type))
                    .count();
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable count data from the database" + ex.getMessage());
        }
        return result;
    }

    /**
     * Return the number of logements by batiment and type.
     *
     * @param batId the id of batiment.
     * @param type  the type of logement.
     * @return int
     */
    @Override
    public synchronized long countLogByBatAndType(long batId, int type)  {
        Log.i(MANAGERS, "Inside of countLogByBatAndType!");
        long result=0;
        try {
            openReadableDb();
            result=daoSession.getLogementDao().queryBuilder()
                    .where(LogementDao.Properties.BatimentId.eq(batId))
                    //.where(LogementDao.Properties.QlCategLogement.eq(type))
                    .count();
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable count data from the database" + ex.getMessage());
        }
        return result;
    }

    @Override
    public long countLogByBat(long batId) {
        Log.i(MANAGERS, "Inside of countLogByBat! batId:"+batId);
        long result=0;
        try {
            openReadableDb();
            result=daoSession.getLogementDao().queryBuilder()
                    .where(LogementDao.Properties.BatimentId.eq(batId)).count();
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable count data from the database" + ex.getMessage());
        }
        return result;
    }

    @Override
    public long countLogement_ByBatiment_byTypeLog_ByStatus(long batId, int typelogement, int statutFormulaire) {
        Log.i(MANAGERS, "Inside of countLogement_ByBatiment_byTypeLog_ByStatus! batId:"+batId + " / typelogement:" + typelogement + " / statutFormulaire:" + statutFormulaire  );
        long result=0;
        try {
            openReadableDb();
            result=daoSession.getLogementDao().queryBuilder()
                    .where(LogementDao.Properties.BatimentId.eq(batId))
                    //.where(LogementDao.Properties.QlCategLogement.eq(typelogement))
                    .where(LogementDao.Properties.Statut.eq(statutFormulaire))
                    .count();
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable count data from the database" + ex.getMessage());
        }
        return result;
    }

    @Override
    public long countLogement_AllFilled_ByBatiment_byTypeLog_ByStatus(long batId, int typelogement, int statutFormulaire, boolean isFillAllField) {
        Log.i(MANAGERS, "Inside of countLogement_AllFilled_ByBatiment_byTypeLog_ByStatus! batId:"+batId + " / typelogement:" + typelogement + " / statutFormulaire:" + statutFormulaire + " / isFillAllField:" + isFillAllField);
        long result=0;
        try {
            openReadableDb();
            result=daoSession.getLogementDao().queryBuilder()
                    .where(LogementDao.Properties.BatimentId.eq(batId))
                    //.where(LogementDao.Properties.QlCategLogement.eq(typelogement))
                    .where(LogementDao.Properties.Statut.eq(statutFormulaire))
                    .where(LogementDao.Properties.IsFieldAllFilled.eq(isFillAllField)).count();
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable count data from the database" + ex.getMessage());
        }
        return result;
    }

    @Override
    public long countIndByLog(long logId) {
        Log.i(MANAGERS, "Inside of countIndByLog!");
        long result=0;
        try {
            openReadableDb();
            result=daoSession.getIndividuDao().queryBuilder()
                    .where(IndividuDao.Properties.LogeId.eq(logId)).count();
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable count data from the database : " + ex.getMessage());
        }
        return result;
    }

    @Override
    public long countIndividus_AllFilled_ByLogement_ByStatus(long logId, int statutFormulaire, boolean isFillAllField) {
        Log.i(MANAGERS, "Inside of countIndividus_AllFilled_ByLogement_ByStatus! logId:"+logId + " / statutFormulaire:" + statutFormulaire + " / isFillAllField:" + isFillAllField);
        long result=0;
        try {
            openReadableDb();
            result=daoSession.getIndividuDao().queryBuilder()
                    .where(IndividuDao.Properties.LogeId.eq(logId))
                    .where(IndividuDao.Properties.Statut.eq(statutFormulaire))
                    .where(IndividuDao.Properties.IsFieldAllFilled.eq(isFillAllField)).count();
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable count data from the database : " + ex.getMessage());
        }
        return result;
    }

    /**
     * Return the number of individu by type of logement.
     *
     * @param logId the id of a logememt.
     * @return int
     */
    @Override
    public synchronized long countIndByLogByStatus(long logId,int status){
        Log.i(MANAGERS, "Inside of countIndByLogByStatus!");
        long result=0;
        try {
            openReadableDb();
            result=daoSession.getIndividuDao().queryBuilder()
                    .where(IndividuDao.Properties.LogeId.eq(logId))
                    .where(IndividuDao.Properties.Statut.eq(status)).count();
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable count data from the database: " + ex.getMessage());
        }
        return result;
    }

    @Override
    public long countIndByMenage(long menageId) {
        Log.i(MANAGERS, "Inside of countIndByMenage!");
        long result=0;
        try {
            openReadableDb();
            result=daoSession.getIndividuDao().queryBuilder()
                    .where(IndividuDao.Properties.MenageId.eq(menageId)).count();
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable count data from the database : " + ex.getMessage());
        }
        return result;
    }

    @Override
    public long countIndividus_AllFilled_ByMenage_ByStatus(long menageId, int statutFormulaire, boolean isFillAllField) {
        Log.i(MANAGERS, "Inside of countDeces_AllFilled_ByMenage_ByStatus! menageId:"+menageId + " / statutFormulaire:" + statutFormulaire + " / isFillAllField:" + isFillAllField);
        long result=0;
        try {
            openReadableDb();
            result=daoSession.getIndividuDao().queryBuilder()
                    .where(IndividuDao.Properties.MenageId.eq(menageId))
                    .where(IndividuDao.Properties.Statut.eq(statutFormulaire))
                    .where(IndividuDao.Properties.IsFieldAllFilled.eq(isFillAllField)).count();
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable count data from the database : " + ex.getMessage());
        }
        return result;
    }

    @Override
    public long countIndByMenageByStatus(long menageId, int status) {
        Log.i(MANAGERS, "Inside of countIndByMenageByStatus!");
        long result=0;
        try {
            openReadableDb();
            result=daoSession.getIndividuDao().queryBuilder()
                    .where(IndividuDao.Properties.MenageId.eq(menageId))
                    .where(IndividuDao.Properties.Statut.eq(status)).count();
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable count data from the database : " + ex.getMessage());
        }
        return result;
    }

    /**
     * Return the number of menages by status of the menage and by logement.
     *
     * @param status the status of the menage
     * @param logId  the id of the logement.
     * @return int
     * @throws ManagerException
     */
    @Override
    public synchronized long countMenageByStatusAndLog(int status, long logId){
        Log.i(MANAGERS, "Inside of countMenageByStatusAndLog!");
        long result=0;
        try {
            openReadableDb();
            result=daoSession.getMenageDao().queryBuilder()
                    .where(MenageDao.Properties.LogeId.eq(logId))
                    .where(MenageDao.Properties.Statut.eq(status)).count();
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable count data from the database"+ex.getMessage());
        }
        return result;
    }

    /**
     * Return the number of menages by logement.
     *
     * @param logId the id of the logement
     * @return int
     */
    @Override
    public synchronized long countMenageByLog(long logId) {
        Log.i(MANAGERS, "Inside of countMenageByLog!");
        long result=0;
        try {
            openReadableDb();
            result=daoSession.getMenageDao().queryBuilder()
                    .where(MenageDao.Properties.LogeId.eq(logId)).count();
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable count data from the database"+ex.getMessage());
        }
        return result;
    }

    @Override
    public long countMenage_AllFilled_ByLogement_ByStatus(long logId, int statutFormulaire, boolean isFillAllField) {
        Log.i(MANAGERS, "Inside of countIndividus_AllFilled_ByLogement_ByStatus! logId:"+logId + " / statutFormulaire:" + statutFormulaire + " / isFillAllField:" + isFillAllField);
        long result=0;
        try {
            openReadableDb();
            result=daoSession.getMenageDao().queryBuilder()
                    .where(MenageDao.Properties.LogeId.eq(logId))
                    .where(MenageDao.Properties.Statut.eq(statutFormulaire))
                    .where(MenageDao.Properties.IsFieldAllFilled.eq(isFillAllField)).count();
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable count data from the database"+ex.getMessage());
        }
        return result;
    }

    /**
     * Return the list of Batiments by status.
     *
     * @param status the status of a batiment
     * @return List<BatimentModel>
     */
    @Override
    public synchronized List<BatimentModel> searchBatByStatus(int status) throws ManagerException {
        Log.i(MANAGERS, "Inside of searchBatByStatus!");
        List<BatimentModel> result=null;
        try {
            openReadableDb();
            List<Batiment> bats=daoSession.getBatimentDao().queryBuilder()
                    .where(BatimentDao.Properties.Statut.eq(status)).list();
            if(bats!=null && bats.size()>0){
                Log.i(MANAGERS, "SIZE: "+bats.size());
                result= ModelMapper.MapToBatimentModel(bats);
            }
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable count data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    @Override
    public synchronized  boolean isRecAlreadyExist(String rec)throws ManagerException{
        Log.i(MANAGERS, "Inside of isRecAlreadyExist!");
        List<RowDataListModel> result=null;
        try {
            openReadableDb();
            Batiment bat=daoSession.getBatimentDao().queryBuilder()
                    .where(BatimentDao.Properties.Qrec.eq(rec)).unique();
            daoSession.clear();
            if(bat!=null){
                return true;
            }
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable count data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return false;
    }

    @Override
    public synchronized List<RowDataListModel> searchListBatByStatus(Short status) throws ManagerException {
        Log.i(MANAGERS, "Inside of searchListBatByStatus!");
        List<RowDataListModel> result=null;
        try {
            openReadableDb();
            List<Batiment> bats=daoSession.getBatimentDao().queryBuilder()
                    .where(BatimentDao.Properties.Statut.eq(status)).list();
            result= ModelMapper.MapToRows(context, bats);
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable count data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    /**
     * Get a batiment by its id.
     *
     * @param batId the id of batiment.
     * @return BatimentModel
     * @throws ManagerException
     */
    @Override
    public synchronized BatimentModel getBatById(long batId)
            throws ManagerException {
        Log.i(MANAGERS, "Inside of getBatById!");
        BatimentModel result=null;
        try {
            openReadableDb();
            //Batiment bat=daoSession.getBatimentDao().load(batId);
            Batiment bat=daoSession.getBatimentDao().loadByRowId(batId);
            if(bat!=null){
                result= ModelMapper.MapToBatimentModel(bat);
            }
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    /**
     * Return the list of logements by type, batiment and by status.
     *
     * @param type   the type of the logement
     * @param batId  the Id of the batimenet
     * @param status the status of the logement
     * @return List<LogementModel>
     * @throws ManagerException
     */
    @Override
    public synchronized List<LogementModel> searchLogByTypeAndBatAndStat(boolean type, long batId, int status)
            throws ManagerException {
        Log.i(MANAGERS, "Inside of searchLogByTypeAndBatAndStat!");
        List<LogementModel> result=null;
        try {
            openReadableDb();
            List<Logement> loges=daoSession.getLogementDao().queryBuilder()
                    .where(LogementDao.Properties.BatimentId.eq(batId))
                    .where(LogementDao.Properties.Statut.eq(status))
                    //.where(LogementDao.Properties.QlCategLogement.eq(type))
                    .list();
            if(loges!=null && loges.size()>0){
                Log.i(MANAGERS, "SIZE:"+loges.size());
                result= ModelMapper.MapToLogementModel(loges);
            }
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    @Override
    public synchronized List<RowDataListModel> searchListLogByTypeAndBatAndStat(int type, long batId, Short status)
            throws ManagerException {
        Log.i(MANAGERS, "Inside of searchLogByTypeAndBatAndStat!");
        List<RowDataListModel> result=null;
        try {
            openReadableDb();
            List<Logement> loges=daoSession.getLogementDao().queryBuilder()
                    .where(LogementDao.Properties.BatimentId.eq(batId))
                    .where(LogementDao.Properties.Statut.eq(status))
                    //.where(LogementDao.Properties.QlCategLogement.eq(type))
                    .list();
            result= ModelMapper.MapToRowsLogement(context, loges);
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    /**
     * Get a logement by its id.
     *
     * @param logId the id of a logement.
     * @return LogementModel
     * @throws ManagerException
     */
    @Override
    public synchronized LogementModel getLogById(long logId)
            throws ManagerException {
        Log.i(MANAGERS, "Inside of getLogById!");
        LogementModel result=null;
        try {
            openReadableDb();
            Logement log=daoSession.getLogementDao().queryBuilder()
                    .where(LogementDao.Properties.LogeId.eq(logId)).unique();
            if(log!=null){
                result= ModelMapper.MapToLogementModel(log);
            }
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    @Override
    public MenageModel getMenageById(long menageId) throws ManagerException {
        Log.i(MANAGERS, "Inside of getMenageById!");
        MenageModel result=null;
        try {
            openReadableDb();
            Menage menage = daoSession.getMenageDao().queryBuilder()
                    .where(MenageDao.Properties.MenageId.eq(menageId)).unique();
            if(menage!=null){
                result= ModelMapper.MapToMenageModel(menage);
            }
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    /**
     * \
     * Return the list of menages by logement.
     *
     * @param logId the id of the logement.
     * @return List<MenageModel>
     * @throws ManagerException
     */
    @Override
    public synchronized List<MenageModel> searchMenageByLog(long logId)
            throws ManagerException {
        Log.i(MANAGERS, "Inside of searchMenageByLog!");
        List<MenageModel> result=null;
        try {
            openReadableDb();
            List<Menage> menages=daoSession.getMenageDao().queryBuilder()
                    .where(MenageDao.Properties.LogeId.eq(logId)).list();
            if(menages!=null && menages.size()>0){
                Log.i(MANAGERS, "SIZE:"+menages.size());
                result= ModelMapper.MapToMenageModel(menages);
            }
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    @Override
    public synchronized List<RowDataListModel> searchListMenageByLog(long logId, Short satut)
            throws ManagerException {
        Log.i(MANAGERS, "Inside of searchMenageByLog!");
        List<RowDataListModel> result=null;
        try {
            openReadableDb();
            List<Menage> menages=daoSession.getMenageDao().queryBuilder()
                    .where(MenageDao.Properties.LogeId.eq(logId))
                    .where(MenageDao.Properties.Statut.eq(satut)).list();

            result= ModelMapper.MapToRowsMenage(context, menages);
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    /**
     * Return the list of menages by logement and by status
     *
     * @param status the status of the menage.
     * @param logId  the id of the logement
     * @return List<MenageModel>
     * @throws ManagerException
     */
    @Override
    public synchronized List<MenageModel> searchMenageByStaAndLog(int status, long logId)
            throws ManagerException {
        Log.i(MANAGERS, "Inside of searchMenageByStaAndLog!");
        List<MenageModel> result=null;
        try {
            openReadableDb();
            List<Menage> menages=daoSession.getMenageDao().queryBuilder()
                    .where(MenageDao.Properties.LogeId.eq(logId))
                    .where(MenageDao.Properties.Statut.eq(status)).list();
            if(menages!=null && menages.size()>0){
                Log.i(MANAGERS, "SIZE:"+menages.size());
                result= ModelMapper.MapToMenageModel(menages);
            }
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    @Override
    public synchronized List<RowDataListModel> searcListhMenageByStaAndLog(Short status, long logId)
            throws ManagerException {
        Log.i(MANAGERS, "Inside of searchMenageByStaAndLog!");
        List<RowDataListModel> result=null;
        try {
            openReadableDb();
            List<Menage> menages=daoSession.getMenageDao().queryBuilder()
                    .where(MenageDao.Properties.LogeId.eq(logId))
                    .where(MenageDao.Properties.Statut.eq(status)).list();

            result= ModelMapper.MapToRowsMenage(context, menages);
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    /**
     * Return the list of individus in a menage.
     *
     * @param menageId the id of a menage.
     * @return List<IndividuModel>
     * @throws ManagerException
     */
    @Override
    public synchronized List<IndividuModel> searchIndByMenage(long menageId)
            throws ManagerException {
        Log.i(MANAGERS, "Inside of searchIndByMenage!");
        List<IndividuModel> result=null;
        try {
            openReadableDb();
            List<Individu> inds=daoSession.getIndividuDao().queryBuilder()
                    .where(IndividuDao.Properties.MenageId.eq(menageId)).list();
            if(inds!=null && inds.size()>0){
                result= ModelMapper.MapToIndividuModel(inds);
            }
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    @Override
    public synchronized List<RowDataListModel> searchListIndByMenageAndStatut(Short statut,long menageId)
            throws ManagerException {
        Log.i(MANAGERS, "Inside of searchIndByMenage!");
        List<RowDataListModel> result=null;
        try {
            openReadableDb();
            List<Individu> inds=daoSession.getIndividuDao().queryBuilder()
                    .where(IndividuDao.Properties.MenageId.eq(menageId))
                    .where(IndividuDao.Properties.Statut.eq(statut)).list();

            result= ModelMapper.MapToRowsIndividu(inds);
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    @Override
    public List<RowDataListModel> searchListIndividu_ByLogement(long logementId) throws ManagerException {
        Log.i(MANAGERS, "Inside of searchListIndividu_ByLogement! logementId: "+ logementId);
        List<RowDataListModel> result=null;
        try {
            openReadableDb();
            List<Individu> inds=daoSession.getIndividuDao().queryBuilder()
                    .where(IndividuDao.Properties.LogeId.eq(logementId)).list();
            result= ModelMapper.MapToRowsIndividuOnly(inds);
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    @Override
    public List<RowDataListModel> searchListIndividu_ByMenage(long menageId) throws ManagerException {
        Log.i(MANAGERS, "Inside of searchListIndividu_ByMenage!");
        List<RowDataListModel> result=null;
        try {
            openReadableDb();
            List<Individu> inds=daoSession.getIndividuDao().queryBuilder()
                    .where(IndividuDao.Properties.MenageId.eq(menageId)).list();
            result= ModelMapper.MapToRowsIndividuOnly(inds);
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    @Override
    public List<RowDataListModel> searchListMenage_ByLogement(long logementId) throws ManagerException {
        Log.i(MANAGERS, "Inside of searchListMenage_ByLogement! logementId: "+ logementId);
        List<RowDataListModel> result=null;
        try {
            openReadableDb();
            List<Menage> inds=daoSession.getMenageDao().queryBuilder()
                    .where(MenageDao.Properties.LogeId.eq(logementId)).list();
            result= ModelMapper.MapToRowsMenage(context, inds) ;
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    @Override
    public List<RowDataListModel> searchListLogement_ByBatiment_ByCategLogement(long batimentId, int categLogement) throws ManagerException {
        Log.i(MANAGERS, "Inside of searchListLogement_ByBatiment_ByCategLogement! batimentId: "+ batimentId + " | categLogement: "+ categLogement);
        List<RowDataListModel> result=null;
        try {
            openReadableDb();
            List<Logement> inds=daoSession.getLogementDao().queryBuilder()
                    .where(LogementDao.Properties.BatimentId.eq(batimentId))
                    //.where(LogementDao.Properties.QlCategLogement.eq(categLogement))
                    .list();
            result= ModelMapper.MapToRowsLogement(context, inds) ;
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    /**
     * Get an individu by menage
     *
     * @param indId The id of an individu
     * @return IndividuModel
     * @throws ManagerException
     */
    @Override
    public synchronized IndividuModel getIndById(long indId)
            throws ManagerException {
        Log.i(MANAGERS, "Inside of getIndById!");
        IndividuModel result=null;
        try {
            openReadableDb();
            Individu ind=daoSession.getIndividuDao().queryBuilder()
                    .where(IndividuDao.Properties.IndividuId.eq(indId)).unique();
            if(ind!=null){
                result= ModelMapper.MapToIndividuModel(ind);
            }
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    /**
     * Return the list of individus by status and by logement
     *
     * @param status The status of an individu
     * @param logId  The id of a logement
     * @return List<IndividuModel>
     * @throws ManagerException
     */
    @Override
    public synchronized List<IndividuModel> searchIndByStaAndLog(int status, long logId)
            throws ManagerException {
        Log.i(MANAGERS, "Inside of searchIndByStaAndLog!");
        List<IndividuModel> result=null;
        try {
            openReadableDb();
            List<Individu> inds=daoSession.getIndividuDao().queryBuilder()
                    .where(IndividuDao.Properties.LogeId.eq(logId))
                    .where(IndividuDao.Properties.Statut.eq(status)).list();
            if(inds!=null && inds.size()>0){
                result= ModelMapper.MapToIndividuModel(inds);
            }
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    @Override
    public synchronized List<RowDataListModel> searchListIndByStaAndLog(Short status, long logId)
            throws ManagerException {
        Log.i(MANAGERS, "Inside of searchIndByStaAndLog!");
        List<RowDataListModel> result=null;
        try {
            openReadableDb();
            List<Individu> inds=daoSession.getIndividuDao().queryBuilder()
                    .where(IndividuDao.Properties.LogeId.eq(logId))
                    .where(IndividuDao.Properties.Statut.eq(status)).list();
            result= ModelMapper.MapToRowsIndividu(inds);
            daoSession.clear();
        }catch(Exception ex){
             Log.e(MANAGERS, "Exception <> unable to get data from the database"+ex.getMessage());
            throw  new ManagerException("<> unable to get data from the database",ex);
        }
        return result;
    }

    @Override
    public IndividuModel searchIndividu_ByNoOrdre_ByIdLienDeParente_ByIdMenage(int NoOrdre, int IdLienDeParente, long IdMenage) throws ManagerException {
        Log.i(MANAGERS, "Inside of searchIndividu_ByNoOrdre_ByIdLienDeParente_ByIdMenage!"
                + "NoOrdre:" + NoOrdre +" / IdLienDeParente:"+ IdLienDeParente + " / IdMenage:" +IdMenage);
        IndividuModel result=null;
        try {
            openReadableDb();
            Individu ind = daoSession.getIndividuDao().queryBuilder()
                    .where(IndividuDao.Properties.Q1NoOrdre.eq(NoOrdre))
                    //.where(IndividuDao.Properties.Qp3LienDeParente.eq(IdLienDeParente))
                    .where(IndividuDao.Properties.MenageId.eq(IdMenage)).unique();
            if(ind!=null){
                result= ModelMapper.MapToIndividuModel(ind);
            }
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "<> unable to get data Individu by NoOrdre, IdLienDeParente, IdMenage from the database \n "+ex.getMessage());
            throw  new ManagerException("<> unable to get data Individu by NoOrdre, IdLienDeParente, IdMenage from the database",ex);
        }
        return result;
    }

    @Override
    public IndividuModel searchIndividu_ByNoOrdre_ByIdLienDeParente_ByIdLogement(int NoOrdre, int IdLienDeParente, long IdLogement) throws ManagerException {
        Log.i(MANAGERS, "Inside of searchIndividu_ByNoOrdre_ByIdLienDeParente_ByIdLogement!"
                + "NoOrdre:" + NoOrdre +" / IdLienDeParente:"+ IdLienDeParente + " / IdLogement:" +IdLogement);
        IndividuModel result=null;
        try {
            openReadableDb();
            Individu ind = daoSession.getIndividuDao().queryBuilder()
                    .where(IndividuDao.Properties.Q1NoOrdre.eq(NoOrdre))
                    //.where(IndividuDao.Properties.Qp3LienDeParente.eq(IdLienDeParente))
                    .where(IndividuDao.Properties.LogeId.eq(IdLogement)).unique();
            if(ind!=null){
                result= ModelMapper.MapToIndividuModel(ind);
            }
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "<> unable to get data Individu by NoOrdre, IdLienDeParente, IdLogement from the database \n "+ex.getMessage());
            throw  new ManagerException("<> unable to get data Individu by NoOrdre, IdLienDeParente, IdLogement from the database",ex);
        }
        return result;
    }

    @Override
    public IndividuModel searchIndividu_ByNoOrdre_ByIdLogement(int noOrdre, long idLogement) throws ManagerException {
        Log.i(MANAGERS, "Inside of searchIndividu_ByNoOrdre_ByIdLogement!"
                + "NoOrdre:" + noOrdre + " / IdLogement:" +idLogement);
        IndividuModel result=null;
        try {
            openReadableDb();
            Individu ind = daoSession.getIndividuDao().queryBuilder()
                    .where(IndividuDao.Properties.Q1NoOrdre.eq(noOrdre))
                    .where(IndividuDao.Properties.LogeId.eq(idLogement)).unique();

            if(ind != null){
                if( ind.getStatut() != null &&
                        ind.getStatut() != Constant.STATUT_MODULE_KI_FINI_1 ) {
                    result = ModelMapper.MapToIndividuModel(ind);
                }else{
                    result = null;
                }
            }
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "<> unable to get data Individu by NoOrdre, IdLogement from the database \n "+ex.getMessage());
            throw  new ManagerException("<> unable to get data Individu by NoOrdre, IdLogement from the database",ex);
        }
        return result;
    }


    @Override
    public IndividuModel searchIndividu_ByNoOrdre_ByIdMenage(int NoOrdre, long IdMenage, boolean statut) throws ManagerException {
        Log.i(MANAGERS, "Inside of searchIndividu_ByNoOrdre_ByIdMenage!"
                + "NoOrdre:" + NoOrdre +" / IdMenage:" +IdMenage);
        IndividuModel result=null;
        try {
            openReadableDb();
            Individu ind = daoSession.getIndividuDao().queryBuilder()
                    .where(IndividuDao.Properties.Q1NoOrdre.eq(NoOrdre))
                    .where(IndividuDao.Properties.MenageId.eq(IdMenage)).unique();
            if(ind!=null){
                if( statut ){
                    if( ind.getStatut() != null && ind.getStatut() != Constant.STATUT_MODULE_KI_FINI_1 ) {
                        result = ModelMapper.MapToIndividuModel(ind);
                    }else{
                        result = null;
                    }
                }else {
                    result= ModelMapper.MapToIndividuModel(ind);
                }
            }
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "<> unable to get data Individu by NoOrdre, IdMenage from the database \n "+ex.getMessage());
            throw  new ManagerException("<> unable to get data Individu by NoOrdre, IdMenage from the database",ex);
        }
        return result;
    }

    @Override
    public MenageModel searchMenage_ByNoOrdre_ByIdLogement(int NoOrdre, long idLogement) throws ManagerException {
        Log.i(MANAGERS, "Inside of searchMenage_ByNoOrdre_ByIdLogement!"
                + "NoOrdre:" + NoOrdre +" / idLogement:" +idLogement);
        MenageModel result=null;
        try {
            openReadableDb();
            Menage men = daoSession.getMenageDao().queryBuilder()
                    .where(MenageDao.Properties.Qm1NoOrdre.eq(NoOrdre))
                    .where(MenageDao.Properties.LogeId.eq(idLogement)).unique();

            if(men != null){
                if( men.getStatut() != null &&
                        men.getStatut() != Constant.STATUT_MODULE_KI_FINI_1 ) {
                    result = ModelMapper.MapToMenageModel(men);
                }else{
                    result = null;
                }
            }
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "<> unable to get data Individu by NoOrdre, idLogement from the database \n "+ex.getMessage());
            throw  new ManagerException("<> unable to get data Individu by NoOrdre, idLogement from the database",ex);
        }
        return result;
    }

    @Override
    public LogementModel searchLogementByNoOrdreByTypeLogByIdBatiment(int NoOrdre, int CategLogement, long IdBatiment) throws ManagerException {
        Log.i(MANAGERS, "Inside of searchLogementByNoOrdreByTypeLogByIdBatiment!" + "NoOrdre:" + NoOrdre +" / IdBatiment:" +IdBatiment );
        LogementModel result=null;
        try {
            openReadableDb();
            Logement logement = daoSession.getLogementDao().queryBuilder()
                    .where(LogementDao.Properties.Qlin1NumeroOrdre.eq(NoOrdre))
                    //.where(LogementDao.Properties.QlCategLogement.eq(CategLogement))
                    .where(LogementDao.Properties.BatimentId.eq(IdBatiment)).unique();

            if(logement != null){
                if( logement.getStatut() != null &&
                        logement.getStatut() != Constant.STATUT_MODULE_KI_FINI_1 ) {
                    result = ModelMapper.MapToLogementModel(logement);
                }else{
                    result = null;
                }
            }
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "<> unable to get data logement from the database \n "+ex.getMessage());
            throw  new ManagerException("<> unable to get data Logement from the database",ex);
        }
        return result;
    }

    //endregion

    //region additional MAppers

    //endregion
}
