package ht.ihsi.rgph.mobile.epc.Backend.Entities;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import ht.ihsi.rgph.mobile.epc.Backend.Entities.Personnel;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.CategorieQuestion;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Question;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.QuestionReponse;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Module;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.QuestionModule;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Departement;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Commune;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Vqse;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.DomaineEtude;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Pays;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Batiment;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Logement;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Menage;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.AncienMembre;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.Individu;

import ht.ihsi.rgph.mobile.epc.Backend.Entities.PersonnelDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.CategorieQuestionDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.QuestionDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.QuestionReponseDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.ModuleDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.QuestionModuleDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.DepartementDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.CommuneDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.VqseDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.DomaineEtudeDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.PaysDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.BatimentDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.LogementDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.MenageDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.AncienMembreDao;
import ht.ihsi.rgph.mobile.epc.Backend.Entities.IndividuDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig personnelDaoConfig;
    private final DaoConfig categorieQuestionDaoConfig;
    private final DaoConfig questionDaoConfig;
    private final DaoConfig questionReponseDaoConfig;
    private final DaoConfig moduleDaoConfig;
    private final DaoConfig questionModuleDaoConfig;
    private final DaoConfig departementDaoConfig;
    private final DaoConfig communeDaoConfig;
    private final DaoConfig vqseDaoConfig;
    private final DaoConfig domaineEtudeDaoConfig;
    private final DaoConfig paysDaoConfig;
    private final DaoConfig batimentDaoConfig;
    private final DaoConfig logementDaoConfig;
    private final DaoConfig menageDaoConfig;
    private final DaoConfig ancienMembreDaoConfig;
    private final DaoConfig individuDaoConfig;

    private final PersonnelDao personnelDao;
    private final CategorieQuestionDao categorieQuestionDao;
    private final QuestionDao questionDao;
    private final QuestionReponseDao questionReponseDao;
    private final ModuleDao moduleDao;
    private final QuestionModuleDao questionModuleDao;
    private final DepartementDao departementDao;
    private final CommuneDao communeDao;
    private final VqseDao vqseDao;
    private final DomaineEtudeDao domaineEtudeDao;
    private final PaysDao paysDao;
    private final BatimentDao batimentDao;
    private final LogementDao logementDao;
    private final MenageDao menageDao;
    private final AncienMembreDao ancienMembreDao;
    private final IndividuDao individuDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        personnelDaoConfig = daoConfigMap.get(PersonnelDao.class).clone();
        personnelDaoConfig.initIdentityScope(type);

        categorieQuestionDaoConfig = daoConfigMap.get(CategorieQuestionDao.class).clone();
        categorieQuestionDaoConfig.initIdentityScope(type);

        questionDaoConfig = daoConfigMap.get(QuestionDao.class).clone();
        questionDaoConfig.initIdentityScope(type);

        questionReponseDaoConfig = daoConfigMap.get(QuestionReponseDao.class).clone();
        questionReponseDaoConfig.initIdentityScope(type);

        moduleDaoConfig = daoConfigMap.get(ModuleDao.class).clone();
        moduleDaoConfig.initIdentityScope(type);

        questionModuleDaoConfig = daoConfigMap.get(QuestionModuleDao.class).clone();
        questionModuleDaoConfig.initIdentityScope(type);

        departementDaoConfig = daoConfigMap.get(DepartementDao.class).clone();
        departementDaoConfig.initIdentityScope(type);

        communeDaoConfig = daoConfigMap.get(CommuneDao.class).clone();
        communeDaoConfig.initIdentityScope(type);

        vqseDaoConfig = daoConfigMap.get(VqseDao.class).clone();
        vqseDaoConfig.initIdentityScope(type);

        domaineEtudeDaoConfig = daoConfigMap.get(DomaineEtudeDao.class).clone();
        domaineEtudeDaoConfig.initIdentityScope(type);

        paysDaoConfig = daoConfigMap.get(PaysDao.class).clone();
        paysDaoConfig.initIdentityScope(type);

        batimentDaoConfig = daoConfigMap.get(BatimentDao.class).clone();
        batimentDaoConfig.initIdentityScope(type);

        logementDaoConfig = daoConfigMap.get(LogementDao.class).clone();
        logementDaoConfig.initIdentityScope(type);

        menageDaoConfig = daoConfigMap.get(MenageDao.class).clone();
        menageDaoConfig.initIdentityScope(type);

        ancienMembreDaoConfig = daoConfigMap.get(AncienMembreDao.class).clone();
        ancienMembreDaoConfig.initIdentityScope(type);

        individuDaoConfig = daoConfigMap.get(IndividuDao.class).clone();
        individuDaoConfig.initIdentityScope(type);

        personnelDao = new PersonnelDao(personnelDaoConfig, this);
        categorieQuestionDao = new CategorieQuestionDao(categorieQuestionDaoConfig, this);
        questionDao = new QuestionDao(questionDaoConfig, this);
        questionReponseDao = new QuestionReponseDao(questionReponseDaoConfig, this);
        moduleDao = new ModuleDao(moduleDaoConfig, this);
        questionModuleDao = new QuestionModuleDao(questionModuleDaoConfig, this);
        departementDao = new DepartementDao(departementDaoConfig, this);
        communeDao = new CommuneDao(communeDaoConfig, this);
        vqseDao = new VqseDao(vqseDaoConfig, this);
        domaineEtudeDao = new DomaineEtudeDao(domaineEtudeDaoConfig, this);
        paysDao = new PaysDao(paysDaoConfig, this);
        batimentDao = new BatimentDao(batimentDaoConfig, this);
        logementDao = new LogementDao(logementDaoConfig, this);
        menageDao = new MenageDao(menageDaoConfig, this);
        ancienMembreDao = new AncienMembreDao(ancienMembreDaoConfig, this);
        individuDao = new IndividuDao(individuDaoConfig, this);

        registerDao(Personnel.class, personnelDao);
        registerDao(CategorieQuestion.class, categorieQuestionDao);
        registerDao(Question.class, questionDao);
        registerDao(QuestionReponse.class, questionReponseDao);
        registerDao(Module.class, moduleDao);
        registerDao(QuestionModule.class, questionModuleDao);
        registerDao(Departement.class, departementDao);
        registerDao(Commune.class, communeDao);
        registerDao(Vqse.class, vqseDao);
        registerDao(DomaineEtude.class, domaineEtudeDao);
        registerDao(Pays.class, paysDao);
        registerDao(Batiment.class, batimentDao);
        registerDao(Logement.class, logementDao);
        registerDao(Menage.class, menageDao);
        registerDao(AncienMembre.class, ancienMembreDao);
        registerDao(Individu.class, individuDao);
    }
    
    public void clear() {
        personnelDaoConfig.getIdentityScope().clear();
        categorieQuestionDaoConfig.getIdentityScope().clear();
        questionDaoConfig.getIdentityScope().clear();
        questionReponseDaoConfig.getIdentityScope().clear();
        moduleDaoConfig.getIdentityScope().clear();
        questionModuleDaoConfig.getIdentityScope().clear();
        departementDaoConfig.getIdentityScope().clear();
        communeDaoConfig.getIdentityScope().clear();
        vqseDaoConfig.getIdentityScope().clear();
        domaineEtudeDaoConfig.getIdentityScope().clear();
        paysDaoConfig.getIdentityScope().clear();
        batimentDaoConfig.getIdentityScope().clear();
        logementDaoConfig.getIdentityScope().clear();
        menageDaoConfig.getIdentityScope().clear();
        ancienMembreDaoConfig.getIdentityScope().clear();
        individuDaoConfig.getIdentityScope().clear();
    }

    public PersonnelDao getPersonnelDao() {
        return personnelDao;
    }

    public CategorieQuestionDao getCategorieQuestionDao() {
        return categorieQuestionDao;
    }

    public QuestionDao getQuestionDao() {
        return questionDao;
    }

    public QuestionReponseDao getQuestionReponseDao() {
        return questionReponseDao;
    }

    public ModuleDao getModuleDao() {
        return moduleDao;
    }

    public QuestionModuleDao getQuestionModuleDao() {
        return questionModuleDao;
    }

    public DepartementDao getDepartementDao() {
        return departementDao;
    }

    public CommuneDao getCommuneDao() {
        return communeDao;
    }

    public VqseDao getVqseDao() {
        return vqseDao;
    }

    public DomaineEtudeDao getDomaineEtudeDao() {
        return domaineEtudeDao;
    }

    public PaysDao getPaysDao() {
        return paysDao;
    }

    public BatimentDao getBatimentDao() {
        return batimentDao;
    }

    public LogementDao getLogementDao() {
        return logementDao;
    }

    public MenageDao getMenageDao() {
        return menageDao;
    }

    public AncienMembreDao getAncienMembreDao() {
        return ancienMembreDao;
    }

    public IndividuDao getIndividuDao() {
        return individuDao;
    }

}