package ht.ihsi.rgph.mobile.epc.Managers;

import java.util.List;

import ht.ihsi.rgph.mobile.epc.Exceptions.ManagerException;
import ht.ihsi.rgph.mobile.epc.Models.CategorieQuestionModel;
import ht.ihsi.rgph.mobile.epc.Models.CommuneModel;
import ht.ihsi.rgph.mobile.epc.Models.DepartementModel;
import ht.ihsi.rgph.mobile.epc.Models.KeyValueModel;
import ht.ihsi.rgph.mobile.epc.Models.ModuleModel;
import ht.ihsi.rgph.mobile.epc.Models.PersonnelModel;
import ht.ihsi.rgph.mobile.epc.Models.QuestionReponseModel;
import ht.ihsi.rgph.mobile.epc.Models.QuestionsModel;
import ht.ihsi.rgph.mobile.epc.Models.VqseModel;

/**
 * FormDataMngr - this interface provides
 *
 * @author Jean Fritz DUVERSEAU
 * @version 1.0
 * @copyright (C) EPC-rgph 2017
 * @date 28/09/2017
 */
public  interface FormDataMngr{

     void closeDbConnections();

    /**
     * Return the categorie of a question
     * @param categorie the categorie of question
     * @return CategorieQuestionModel
     */

    CategorieQuestionModel getCategorieQuestion(String categorie)throws ManagerException;
    /**
     * Check the status of a module
     *
     * @param type   the type of the module
     * @param status the status of the module
     * @return ModuleModel
     * @throws ManagerException
     */
     ModuleModel checkModule(int type, int status) throws ManagerException;

    ModuleModel checkListModuleByType(int type) throws ManagerException;

    /**
     * Get the first question on a module
     *
     * @param moduleId the id of the module
     * @return QuestionsModel
     * @throws ManagerException
     */
     QuestionsModel getFirstQuestionOfModule(String moduleId) throws ManagerException;

    /**
     * Get the next question
     *
     * @param id the id of question
     * @return QuestionsModel
     * @throws ManagerException
     */
     QuestionsModel getNextQuestionByCode(String id) throws ManagerException;

    List<QuestionReponseModel> searchQuestionReponseByQuestion(String codeQuestion) throws ManagerException;

    List<QuestionReponseModel> searchResponsesByQuestion(String questionId, String codeParent) throws ManagerException;
    /**
     * Get all of the countries(pays). Returns a pair of key and value.
     * The Key is the id of the country and the value is the name.
     *
     * @return List<KeyValueModel>
     * @throws ManagerException
     */
     List<KeyValueModel> getAllPays() throws ManagerException;

    /**
     * Get all the departements.Returns a pair of key and value.
     * The Key is the id of the country and the value is the name.
     *
     * @return List<KeyValueModel>
     * @throws ManagerException
     */
     List<KeyValueModel> getAllDepartement() throws ManagerException;

    DepartementModel getDepartementById(String departementId) throws ManagerException;

    /**
     * Get all the comunnes by departement. Returns a pair of key and value.
     * The Key is the id of the country and the value is the name.
     *
     * @param deptId the id of the departement
     * @return List<CommuneModel>
     * @throws ManagerException
     */
     List<CommuneModel> getAllCommuneByIdDept(String deptId) throws ManagerException;

    CommuneModel getCommuneById(String comId) throws ManagerException;

    /**
     * Get all the VQSE by Commune. Returns a pair of key and value.
     * The Key is the id of the country and the value is the name.
     *
     * @param comId the id of a Commune
     * @return List<VqseModel>
     * @throws ManagerException
     */
     List<VqseModel> getAllVqseByIdCom(String comId) throws ManagerException;

    VqseModel getVqseById(String vqseId) throws ManagerException;

    /**
     * Get all The domaine etude. Returns a pair of key and value.
     * The Key is the id of the country and the value is the name.
     *
     * @return List<KeyValueModel>
     * @throws ManagerException
     */
     List<KeyValueModel> getAllDomaineEtude() throws ManagerException;

    QuestionReponseModel getQuestionResponsesByCodeQuestionByCodeReponse(String codeQuestion, String codeReponse) throws ManagerException;

    QuestionReponseModel getQuestionResponsesByCodeQuestionByCodeReponseIsParent(String codeQuestion, String codeReponse) throws ManagerException;

    /**
     *
     * @param NomUtilisateur
     * @param MotDePasse
     * @return PersonnelModel
     * @throws ManagerException
     */
    PersonnelModel getPersonnelInfo(String NomUtilisateur, String MotDePasse) throws ManagerException;
}
