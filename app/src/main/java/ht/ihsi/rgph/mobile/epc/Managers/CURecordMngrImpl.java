package ht.ihsi.rgph.mobile.epc.Managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import ht.ihsi.rgph.mobile.epc.Backend.Entities.Batiment;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.BatimentDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.DaoSession;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Individu;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.IndividuDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Logement;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.LogementDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Menage;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.MenageDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Personnel;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.PersonnelDao;
import ht.ihsi.rgph.mobile.epc.Constant.Constant;
import ht.ihsi.rgph.mobile.epc.Exceptions.ManagerException;
import ht.ihsi.rgph.mobile.epc.Exceptions.TextEmptyException;
import ht.ihsi.rgph.mobile.epc.Mappers.ModelMapper;
import ht.ihsi.rgph.mobile.epc.Models.BatimentModel;
import ht.ihsi.rgph.mobile.epc.Models.IndividuModel;
import ht.ihsi.rgph.mobile.epc.Models.LogementModel;
import ht.ihsi.rgph.mobile.epc.Models.MenageModel;
import ht.ihsi.rgph.mobile.epc.Models.PersonnelModel;
import ht.ihsi.rgph.mobile.epc.Utilities.ToastUtility;

/**
 * Created by jadme on 3/22/2016.
 */
public class CURecordMngrImpl extends AbstractDatabaseManager implements CURecordMngr {

    private static CURecordMngrImpl instance;

    public CURecordMngrImpl(final Context content) {
        super(content);
    }

    //region required methods
    public static CURecordMngrImpl getInstance(Context context) {

        if (instance == null) {
            instance = new CURecordMngrImpl(context);
        }

        return instance;
    }

    public DaoSession getDaoSession() {
        DaoSession session = daoSession;
        return session;
    }

    @Override
    public void closeDbConnections() {
        closeConnections();
        if (instance != null) {
            instance = null;
        }
    }
    //endregion

    //region database managers

    /**
     * Save a new Batiment
     *
     * @param batiment the object batiment
     * @return BatimentModel
     * @throws ManagerException
     */
    @Override
    public synchronized BatimentModel saveBatiment(BatimentModel batiment, String userCode) throws ManagerException {
        if (batiment != null) {
            openWritableDb();
            BatimentDao batimentDao = daoSession.getBatimentDao();
            long batimentId = batimentDao.insert(ModelMapper.MapToBatiment(batiment));
            if (batimentId != 0) {
                Batiment bat = batimentDao.load(batimentId);
                //Batiment bat = batimentDao.loadByRowId(batimentId);
                Log.d(ToastUtility.TAG, "saveBatiment / Batiment Insert ID:" + bat.getBatimentId());
                batiment.setBatimentId(batimentId);
                daoSession.clear();
                return batiment;
            } else {
                throw new ManagerException("Error while Inserting the batiment");
            }

        } else {
            Log.d("saveBatiment", "Batiment is null ");
        }
        return null;
    }

    @Override
    public synchronized BatimentModel SaveBatiment(Long id, BatimentModel batiment, int typeEvenement, String userCode) throws ManagerException {
        if( id <= 0 ){
            return saveBatiment(batiment, userCode);
        }else{
            if( typeEvenement == Constant.ACTION_AFFICHER ) {
                return batiment;
            }else{
                batiment.setBatimentId(id);
                return updateBatiment(batiment, userCode);
            }
        }
    }

    /**
     * save a new logement
     *
     * @param logement the object logement
     * @return LogementModel
     * @throws ManagerException
     */
    @Override
    public synchronized LogementModel saveLogement(LogementModel logement, String userCode) throws ManagerException {
        if (logement != null) {
            openWritableDb();
            LogementDao logementDao = daoSession.getLogementDao();
            long logementId = logementDao.insert(ModelMapper.MapToLogement(logement));
            if (logementId != 0) {
                //Logement log = logementDao.load(logementId);
                logement.setLogeId(logementId);
                Log.d(ToastUtility.TAG, "saveLogement / Logement Insert ID:" + logementId + " Batiment ID:" + logement.getBatimentId() + " SDE:" + logement.getSdeId());
                daoSession.clear();
                return logement;
            } else {
                throw new ManagerException("Error while Inserting the logement");
            }
        }
        return null;
    }

    @Override
    public LogementModel SaveLogement(Long id, LogementModel logementModel, int typeEvenement, String userCode) throws ManagerException {
        if( id <= 0){
            logementModel = saveLogement(logementModel, userCode);
        } else{
            if( typeEvenement == Constant.ACTION_AFFICHER ) {
                return logementModel;
            }else {
                logementModel.setLogeId(id);
                logementModel = updateLogement(logementModel, userCode);
            }
        }
        return logementModel;
    }

    /**
     * Save a new menage
     *
     * @param menage the object menage
     * @return MenageModel
     * @throws ManagerException
     */
    @Override
    public synchronized MenageModel saveMenage(MenageModel menage, String userCode) throws ManagerException {
        if (menage != null) {
            MenageModel menageModel = new MenageModel();
            openWritableDb();
            MenageDao menageDao = daoSession.getMenageDao();
            long menageId = menageDao.insert(ModelMapper.MapToMenage(menage));
            if (menageId != 0) {
                Log.d(ToastUtility.TAG, "saveMenage / Menage Inserted Id:" + menageId + " Batiment ID:" + menage.getBatimentId() + " Logement:" + menage.getLogeId() + " SDE:" + menage.getSdeId());
                menageModel = menage;
                menageModel.setMenageId(menageId);
                daoSession.clear();
                return menageModel;
            } else {
                throw new ManagerException("Error while Inserting the menage");
            }
        }
        return null;
    }

    @Override
    public MenageModel SaveMenage(Long id, MenageModel menage, int typeEvenement, String userCode) throws ManagerException {
        if( id <= 0 ){
            return saveMenage(menage, userCode);
        }else{
            if( typeEvenement == Constant.ACTION_AFFICHER ) {
                return menage;
            }else {
                menage.setMenageId(id);
                return updateMenage(menage, userCode);
            }
        }
    }

    /**
     * Save a new individu.
     *
     * @param individu
     * @return IndividuModel
     * @throws ManagerException
     */
    @Override
    public synchronized IndividuModel saveIndividu(IndividuModel individu, String userCode) throws ManagerException {
        if (individu != null) {
            IndividuModel individuModel = new IndividuModel();
            openWritableDb();
            IndividuDao individuDao = daoSession.getIndividuDao();
            //Individu ind = ModelMapper.MapToIndividu(individu);
            long individuId = individuDao.insert(ModelMapper.MapToIndividu(individu));
            if (individuId != 0) {
                Log.d(ToastUtility.TAG, "saveIndividu / Save Individu Insert Id:" + individuId + " Batiment ID:" + individu.getBatimentId() + " Logement:" + individu.getLogeId() + " SDE:" + individu.getSdeId()+" NOM:"+individu.getQp2BNom());
                individuModel = individu;
                individuModel.setIndividuId(individuId);
                daoSession.clear();
                return individuModel;
            } else {
                throw new ManagerException("Error while inserting the individu");
            }
        }
        return null;
    }

    @Override
    public IndividuModel SaveIndividu(Long id, IndividuModel individu, int typeEvenement, String userCode) throws ManagerException {
        if( id <= 0 ){
            return saveIndividu(individu, userCode);
        }else{
            if( typeEvenement == Constant.ACTION_AFFICHER ) {
                return individu;
            }else {
                individu.setIndividuId(id);
                return updateIndividu(individu, userCode);
            }
        }
    }

    @Override
    public PersonnelModel savePersonnel(PersonnelModel personnelModel, String userCode) throws ManagerException {
        if ( personnelModel != null ) {
            openWritableDb();
            PersonnelDao personnelDao = daoSession.getPersonnelDao();
            long idpersonne = personnelDao.insert(ModelMapper.MapTo(personnelModel));
            if ( idpersonne != 0 ) {
                Personnel bat = personnelDao.load(idpersonne);
                Log.d(ToastUtility.TAG, "savePersonnelModel / Insert ID:" + bat.getPersId() );
                personnelModel.setPersId(idpersonne);
                daoSession.clear();
                return personnelModel;
            } else {
                throw new ManagerException("Error while Inserting the personnelModel ");
            }
        } else {
            Log.d(ToastUtility.TAG + "savePersonnel", "personnel is null ");
        }
        return null;
    }

    @Override
    public PersonnelModel SavePersonnel(long id, PersonnelModel personnelModel, String userCode) throws ManagerException, TextEmptyException {
        try {
            if (id <= 0) {
                Validation(personnelModel);
                personnelModel = savePersonnel(personnelModel, userCode);
            } else if (id > 0) {
                personnelModel.setPersId(id);
                personnelModel = updatePersonnel(personnelModel, userCode);
            }
        }catch (TextEmptyException ex){
            throw ex;
        }
        return personnelModel;
    }
    private void Validation(PersonnelModel personnelModel) throws TextEmptyException {
        if( GetPersonnelByCompteUtilisateur(personnelModel) ){
            throw new TextEmptyException("Ce Compte Utilisateur [ "+ personnelModel.getNomUtilisateur() +" ] est déjà enregistré");
        }
    }
    private boolean GetPersonnelByCompteUtilisateur(PersonnelModel personnelModel) {
        Log.i(MANAGERS, "Inside of GetPersonnelByCompteUtilisateur! / codeSDE :"+personnelModel.getPersId());
        boolean result = false;
        //try {
        openReadableDb();
        Personnel loges = daoSession.getPersonnelDao().queryBuilder()
                .where(PersonnelDao.Properties.NomUtilisateur.eq(personnelModel.getNomUtilisateur())).unique();
        //result= MapToRowsBatiment(loges);
        daoSession.clear();
        if (loges == null) {
            result = false;
        }else if (loges != null) {
            long id = 0;
            if ( personnelModel.getPersId() > 0 && personnelModel != null ){
                id = personnelModel.getPersId();
            }
            if( id == 0 ){
                result = true;
            }else if (loges.getPersId() != id ){
                result = true;
            }else{
                result = false;
            }
        }
        //} catch (Exception ex) {
        //    throw ex;
        //}
        return result;
    }

    /**
     * Save a new entity
     *
     * @param entite
     * @return
     */
    @Override
    public synchronized <T> T saveEntity(T entite) throws ManagerException {
        if (entite.getClass() == BatimentModel.class) {
            saveBatiment((BatimentModel) entite,"");
            return entite;
        }
        if (entite.getClass() == LogementModel.class) {
            saveLogement((LogementModel) entite,"");
            return entite;
        }
        if (entite.getClass() == MenageModel.class) {
            saveMenage((MenageModel) entite,"");
            return entite;
        }
        if (entite.getClass() == IndividuModel.class) {
            saveIndividu((IndividuModel) entite,"");
            return entite;
        }
        return null;
    }


    /**
     * Update a batiment
     *
     * @param batiment
     * @return BatimentModel
     * @throws ManagerException
     */
    @Override
    public synchronized BatimentModel updateBatiment(BatimentModel batiment, String userCode) throws ManagerException {
        if (batiment != null) {
            openReadableDb();
            BatimentDao batimentDao = daoSession.getBatimentDao();
            Log.d(ToastUtility.TAG, "BATIMENT UPDATING / Batiment Insert ID:" + batiment.getBatimentId() + "/SDE: " + batiment.getSdeId() + "REC:" + batiment.getQrec());
            Batiment bat = batimentDao.load(batiment.getBatimentId());
            //Batiment bat = batimentDao.loadByRowId(batiment.getBatimentId());
            if (bat != null) {
                try {
                    bat = ModelMapper.MapToBatiment(batiment);
                    bat.setBatimentId(batiment.getBatimentId());

                    batimentDao.update(bat);
                    Log.d(ToastUtility.TAG, "BATIMENT UPDATED / Batiment Insert ID:" + bat.getBatimentId() + "/SDE: " + bat.getSdeId() + "REC:" + bat.getQrec() );
                    daoSession.clear();
                } catch (Exception ex) {
                    throw new ManagerException("" + ex.getMessage());
                }
                daoSession.clear();
                return batiment;
            }
        }
        return null;
    }

    @Override
    public int updateStatutBatiment(long IdBatiment, short Statut, boolean isFieldAllFilled, String userCode) throws ManagerException {
        if (IdBatiment > 0 ) {
            try {
                openReadableDb();
                BatimentDao batimentDao = daoSession.getBatimentDao();
                Batiment bat = batimentDao.load(IdBatiment);
                if (bat != null) {
                    bat.setStatut(Statut);
                    bat.setIsFieldAllFilled(isFieldAllFilled);
                    bat.setIsSynchroToAppSup(false);
                    bat.setIsSynchroToCentrale(false);
                    batimentDao.update(bat);
                    return 1;
                }
            } catch (Exception ex) {
                throw new ManagerException("" + ex.getMessage());
            } finally {
                daoSession.clear();
            }
        }
        return 0;
    }

    /**
     * Update a logement.
     *
     * @param logement
     * @return LogementModel
     * @throws ManagerException
     */
    @Override
    public synchronized LogementModel updateLogement(LogementModel logement, String userCode) throws ManagerException {
        if (logement != null) {
            openReadableDb();
            LogementDao logementDao = daoSession.getLogementDao();
            Logement log=logementDao.load(logement.getLogeId());
            //Logement log=logementDao.loadByRowId(logement.getLogeId());
            Log.d(ToastUtility.TAG, "LOGEMENT B. UPDATING / BID:"+logement.getBatimentId()+" LOG:"+logement.getLogeId()+" SDE:"+logement.getSdeId());
            if (log != null) {
                log = ModelMapper.MapToLogement(logement);
                log.setLogeId(logement.getLogeId());
                try {
                    logementDao.update(log);
                    Log.d(ToastUtility.TAG, "LOGEMENT B. UPDATED / BID:" + log.getBatimentId() + " LOG:" + log.getLogeId() + " SDE:" + log.getSdeId());
                    daoSession.clear();
                    return ModelMapper.MapToLogementModel(log);
                } catch (Exception ex) {
                    throw new ManagerException("Manager Exception: " + ex.getMessage());
                }

            }
        }
        return null;
    }

    @Override
    public int updateStatutLogement(long idLogement, short Statut, boolean isFieldAllFilled, String userCode) throws ManagerException {
        if (idLogement > 0 ) {
            try {
                openReadableDb();
                LogementDao logementDao = daoSession.getLogementDao();
                Logement obj = logementDao.load(idLogement);
                if (obj != null) {
                    obj.setStatut(Statut);
                    obj.setIsFieldAllFilled(isFieldAllFilled);
                    //obj.setIsSynchroToAppSup(false);
                    //obj.setIsSynchroToCentrale(false);
                    logementDao.update(obj);
                    return 1;
                }
            } catch (Exception ex) {
                throw new ManagerException("" + ex.getMessage());
            } finally {
                daoSession.clear();
            }
        }
        return 0;
    }

    /**
     * Update a menage.
     *
     * @param menage
     * @return MenageModel
     * @throws ManagerException
     */
    @Override
    public synchronized MenageModel updateMenage(MenageModel menage, String userCode) throws ManagerException {
        if (menage != null) {
            openReadableDb();
            MenageDao menageDao = daoSession.getMenageDao();
            Menage men = menageDao.load(menage.getMenageId());
            //QueryBuilder qb = menageDao.queryBuilder();
            //qb.where(MenageDao.Properties.BatimentId.eq(menage.getBatimentId())).and(MenageDao.Properties.LogeId.eq(menage.getLogeId()), MenageDao.Properties.MenageId.eq(menage.getMenageId()));
            //Menage men = (Menage) qb.unique();
            if (men != null) {
                try {
                    men = ModelMapper.MapToMenage(menage);
                    men.setMenageId(menage.getMenageId());
                    menageDao.update(men);
                    Log.d(ToastUtility.TAG, "updateMenage / Found Update" + men.getMenageId());
                    daoSession.clear();
                    return ModelMapper.MapToMenageModel(men);
                } catch (Exception ex) {
                    throw new ManagerException("" + ex.getMessage());
                }
            }
        }
        return null;
    }

    @Override
    public int updateStatutMenage(long idMenage, short Statut, boolean isFieldAllFilled, String userCode) throws ManagerException {
        if (idMenage > 0 ) {
            try {
                openReadableDb();
                MenageDao menageDao = daoSession.getMenageDao();
                Menage obj = menageDao.load(idMenage);
                if (obj != null) {
                    obj.setStatut(Statut);
                    obj.setIsFieldAllFilled(isFieldAllFilled);
                    menageDao.update(obj);
                    return 1;
                }
            } catch (Exception ex) {
                throw new ManagerException("" + ex.getMessage());
            } finally {
                daoSession.clear();
            }
        }
        return 0;
    }

    /**
     * Update an individu.
     *
     * @param individu
     * @return IndividuModel
     * @throws ManagerException
     */
    @Override
    public synchronized IndividuModel updateIndividu(IndividuModel individu, String userCode) throws ManagerException {
        if (individu != null) {
            //QueryBuilder qb = individuDao.queryBuilder();
            //qb.where(IndividuDao.Properties.BatimentId.eq(individu.getBatimentId())).and(IndividuDao.Properties.LogeId.eq(individu.getLogeId()),
            //        IndividuDao.Properties.MenageId.eq(individu.getMenageId()), IndividuDao.Properties.IndividuId.eq(individu.getIndividuId()));
            //Individu ind = (Individu) qb.unique();
            openReadableDb();
            IndividuDao individuDao = daoSession.getIndividuDao();
            Log.d(ToastUtility.TAG, "INDIVIDU UPDATING  ID:" + individu.getIndividuId() );
            Individu ind  = individuDao.load(individu.getIndividuId());
            if (ind.getIndividuId() != 0) {
                try {
                    ind = ModelMapper.MapToIndividu(individu);
                    ind.setIndividuId(individu.getIndividuId());
                    individuDao.update(ind);
                    Log.d(ToastUtility.TAG, "updateIndividu / Individu Update:" + ind.getIndividuId());
                    daoSession.clear();
                    return ModelMapper.MapToIndividuModel(ind);
                } catch (Exception ex) {
                    throw new ManagerException("Impossible De faire la mise à jour" );
                }
            }
        }
        return null;
    }

    @Override
    public int updateStatutIndividu(long idIndividu, short Statut, boolean isFieldAllFilled, String userCode) throws ManagerException {
        if (idIndividu > 0 ) {
            try {
                openReadableDb();
                IndividuDao individuDao = daoSession.getIndividuDao();
                Individu obj = individuDao.load(idIndividu);
                if (obj != null) {
                    obj.setStatut(Statut);
                    obj.setIsFieldAllFilled(isFieldAllFilled);
                    individuDao.update(obj);
                    return 1;
                }
            } catch (Exception ex) {
                throw new ManagerException("" + ex.getMessage());
            } finally {
                daoSession.clear();
            }
        }
        return 0;
    }

    @Override
    public PersonnelModel updatePersonnel(PersonnelModel personnelModel, String userCode) throws ManagerException {
        if (personnelModel != null) {
            openReadableDb();
            PersonnelDao personnelDao = daoSession.getPersonnelDao();
            Personnel personnel = personnelDao.load(personnelModel.getPersId());
            //Log.d(ToastUtility.TAG, " B. UPDATING / BID:"+personnelModel.getPersId()  );
            if (personnel != null) {
                personnel = ModelMapper.MapTo(personnelModel);
                personnel.setPersId(personnelModel.getPersId());
                try {
                    personnelDao.update(personnel);
                    //Log.d(ToastUtility.TAG, "PERSONNEL UPDATING / BID:"+personnelModel.getPersId()  );
                    daoSession.clear();
                    return ModelMapper.MapTo(personnel);
                } catch (Exception ex) {
                    throw new ManagerException("Manager Exception: " + ex.getMessage());
                }
            }
        }
        return null;
    }

    @Override
    public PersonnelModel updateAllPersonnel(long persId, String userCode) throws ManagerException {
        try {
            openReadableDb();
            SQLiteDatabase db = getDatabase();

            ContentValues value = new ContentValues();
            value.put(PersonnelDao.Properties.EstActif.columnName, 0);

            db.update(PersonnelDao.TABLENAME, value, "" + PersonnelDao.Properties.PersId.columnName + " <> ?"
                            +" AND " + PersonnelDao.Properties.PersId.columnName + " <> 1"
                            +" AND " + PersonnelDao.Properties.PersId.columnName + " <> 2"
                            +" AND " + PersonnelDao.Properties.ProfileId.columnName + " = " + Constant.PRIVILEGE_AGENT,
                    new String[] { String.valueOf(persId) });

            db.close();
            daoSession.clear();
        } catch (Exception ex) {
            Log.i(MANAGERS, "<> unable to get data from the database " + ex.getMessage());
            throw new ManagerException("<> unable to get data from the database ", ex);
        }
        return null;
    }

    /**
     * Update an entity
     *
     * @param entite
     * @return T entity.
     */
    @Override
    public synchronized <T> T updateEntity(T entite) throws ManagerException {
        try {
            if (entite.getClass() == BatimentModel.class) {
                updateBatiment((BatimentModel) entite, "");
                return entite;
            }
            if (entite.getClass() == LogementModel.class) {
                updateLogement((LogementModel) entite, "");
                return entite;
            }
            if (entite.getClass() == MenageModel.class) {
                updateMenage((MenageModel) entite, "");
                return entite;
            }
            if (entite.getClass() == IndividuModel.class) {
                updateIndividu((IndividuModel) entite, "");
                return entite;
            }
        } catch (Exception ex) {
            throw new ManagerException("" + ex.getMessage());
        }
        return null;
    }

    /**
     * Increment the number of Logement Collectif in a batiment and change the status
     *
     * @param batId  the id of a batiment
     * @param status the status of the batiment
     * @return BatimentModel
     * @throws ManagerException
     */
    @Override
    public synchronized BatimentModel incNbLogCAndStatInBat(long batId, int status) throws ManagerException {
        if (batId != 0) {
            BatimentModel batimentModel = new BatimentModel();
            openReadableDb();
            BatimentDao batimentDao = daoSession.getBatimentDao();
            Batiment bat = batimentDao.load(batId);
            //Batiment bat = batimentDao.loadByRowId(batId);
            if (bat.getBatimentId() != 0) {
                //short inc = (short) (bat.getQb8NbreLogeCollectif() + 1);
                //bat.setQb8NbreLogeCollectif(inc);
                bat.setStatut((short) status);
                openWritableDb();
                batimentDao.update(bat);
                Log.d(ToastUtility.TAG, "incNbLogIAndStatInBat / LG Ind Inc");
                daoSession.clear();
                return ModelMapper.MapToBatimentModel(bat);

            }

        }
        return null;

    }

    /**
     * Increment  the number of Logement Individuel in a batiment and change the status
     *
     * @param batId  the id of a batiment
     * @param status the status
     * @return BatimentModel
     * @throws ManagerException
     */
    @Override
    public synchronized BatimentModel incNbLogIAndStatInBat(long batId, int status) throws ManagerException {
        if (batId != 0) {
            openReadableDb();
            BatimentDao batimentDao = daoSession.getBatimentDao();
            Batiment bat = batimentDao.load(batId);
            //Batiment bat = batimentDao.loadByRowId(batId);
            if (bat.getBatimentId() != 0) {
                //int inc = bat.getQb8NbreLogeIndividuel() + 1;
                //bat.setQb8NbreLogeIndividuel((short) inc);
                bat.setStatut((short) status);
                openWritableDb();
                batimentDao.update(bat);
                Log.d(ToastUtility.TAG, "CRUD-UPDATE / BATIMENT UPDATE");
                daoSession.clear();
                return ModelMapper.MapToBatimentModel(bat);
            }
        }
        return null;
    }

    /**
     * Increment the number of Individu in a Logement Collectif and change the status
     *
     * @param logId  the id of a logement
     * @param status the status
     * @return LogementModel
     * @throws ManagerException
     */
    @Override
    public synchronized LogementModel incNbIndAndStatInLC(long logId, int status) throws ManagerException {
        if (logId != 0) {
            openReadableDb();
            LogementDao logementDao = daoSession.getLogementDao();
           Logement logement = logementDao.load(logId);
            //Logement logement = logementDao.loadByRowId(logId);
            //short inc = (short) (logement.getQlin8NbreIndividuVivant() + 1);
            //logement.setQlin11NbreIndividuVivant(inc);
            logement.setStatut((short) status);
            openWritableDb();
            logementDao.update(logement);
            Log.d(ToastUtility.TAG, "CRUD-UPDATE / LOGEMENT UPDATE");
            daoSession.clear();
            return ModelMapper.MapToLogementModel(logement);
        }
        return null;
    }

    /**
     * Increment the number of Individus in a Logement Individuel and change the status
     *
     * @param logId  the id of logement
     * @param status the status
     * @return LogementModel
     * @throws ManagerException
     */
    @Override
    public synchronized LogementModel incNbMenAndStatInLI(long logId, int status) throws ManagerException {
        if (logId != 0) {
            openReadableDb();
            LogementDao logementDao = daoSession.getLogementDao();
            Logement logement = logementDao.load(logId);
            //Logement logement = logementDao.loadByRowId(logId);
            //int inc = logement.getQlin9NbreTotalMenage() + 1;
            //logement.setQlin9NbreTotalMenage((short) inc);
            logement.setStatut((short) status);
            openWritableDb();
            logementDao.update(logement);
            Log.d(ToastUtility.TAG, "CRUD-UPDATE / LOGEMENT UPDATE");
            daoSession.clear();
            return ModelMapper.MapToLogementModel(logement);
        }
        return null;
    }

    /**
     * Increment  the number of Individus in a Menage and change the status
     *
     * @param menId  the id of a menage
     * @param status the status of the menage
     * @return MenageModel
     * @throws ManagerException
     */
    @Override
    public synchronized MenageModel incNbIndAndStatInMen(long menId, int status) throws ManagerException {
        if (menId != 0) {
            openReadableDb();
            MenageDao menageDao = daoSession.getMenageDao();
            Menage menage = menageDao.load(menId);
            //Menage menage = menageDao.loadByRowId(menId);
            menage.setQm11TotalIndividuVivant((short) (menage.getQm11TotalIndividuVivant() + 1));
            menage.setStatut((short) status);
            openWritableDb();
            menageDao.update(menage);
            Log.d(ToastUtility.TAG, "CRUD-UPDATE / MENAGE UPDATE");
            daoSession.clear();
            return ModelMapper.MapToMenageModel(menage);

        }
        return null;
    }

    /**
     * Increment  the number of Deces in a Menage and change the status
     *
     * @param menId  the id of a menage
     * @param status the status of the menage
     * @return ManagerException
     * @throws ManagerException
     */
    @Override
    public synchronized MenageModel incNbDecesAndStatInMen(long menId, int status) throws ManagerException {
        if (menId != 0) {
            openReadableDb();
            MenageDao menageDao = daoSession.getMenageDao();
            Menage menage = menageDao.load(menId);
            //Menage menage = menageDao.loadByRowId(menId);
            //int count =  menage.getQm12NbreDecede() + 1;
            //menage.setQm12NbreDecede((short) count);
            menage.setStatut((short) status);
            openWritableDb();
            menageDao.update(menage);
            Log.d(ToastUtility.TAG, "CRUD-UPDATE / MENAGE UPDATE");
            daoSession.clear();
            return ModelMapper.MapToMenageModel(menage);

        }
        return null;
    }

    /**
     * Increment the number of Emigre in a Menage and change the status
     *
     * @param menId  the id of a menage
     * @param status the status of the menage
     * @return MenageModel
     * @throws ManagerException
     */
    @Override
    public synchronized MenageModel incNbEmAndStatInMen(long menId, int status) throws ManagerException {
        if (menId != 0) {
            openReadableDb();
            MenageDao menageDao = daoSession.getMenageDao();
            Menage menage = menageDao.load(menId);
            //Menage menage = menageDao.loadByRowId(menId);
            //menage.setQm11NbreEmigre((short) (menage.getQm11NbreEmigre() + 1));
            menage.setStatut((short) status);
            openWritableDb();
            menageDao.update(menage);
            Log.d(ToastUtility.TAG, "CRUD-UPDATE / MENAGE UPDATE");
            daoSession.clear();
            return ModelMapper.MapToMenageModel(menage);

        }
        return null;
    }

    //endregion
}
