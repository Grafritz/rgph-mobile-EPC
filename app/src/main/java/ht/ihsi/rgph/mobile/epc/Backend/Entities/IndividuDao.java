package ht.ihsi.rgph.mobile.epc.Backend.Entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import ht.ihsi.rgph.mobile.epc.Backend.Entities.Individu;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "tbl_individu".
*/
public class IndividuDao extends AbstractDao<Individu, Long> {

    public static final String TABLENAME = "tbl_individu";

    /**
     * Properties of entity Individu.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property IndividuId = new Property(0, Long.class, "individuId", true, "individuId");
        public final static Property MenageId = new Property(1, Long.class, "menageId", false, "menageId");
        public final static Property LogeId = new Property(2, Long.class, "logeId", false, "logeId");
        public final static Property BatimentId = new Property(3, Long.class, "batimentId", false, "batimentId");
        public final static Property SdeId = new Property(4, String.class, "sdeId", false, "sdeId");
        public final static Property Q1NoOrdre = new Property(5, Short.class, "q1NoOrdre", false, "q1NoOrdre");
        public final static Property Qp2APrenom = new Property(6, String.class, "qp2APrenom", false, "qp2APrenom");
        public final static Property Qp2BNom = new Property(7, String.class, "qp2BNom", false, "qp2BNom");
        public final static Property Qp4Sexe = new Property(8, Short.class, "qp4Sexe", false, "qp4Sexe");
        public final static Property Q5EstMembreMenage = new Property(9, Short.class, "q5EstMembreMenage", false, "q5EstMembreMenage");
        public final static Property Q6aMembreMenageDepuisQuand = new Property(10, Short.class, "q6aMembreMenageDepuisQuand", false, "q6aMembreMenageDepuisQuand");
        public final static Property Q6bDateJour = new Property(11, Short.class, "q6bDateJour", false, "q6bDateJour");
        public final static Property Q6bDateMois = new Property(12, Short.class, "q6bDateMois", false, "q6bDateMois");
        public final static Property Q6bDateAnnee = new Property(13, String.class, "q6bDateAnnee", false, "q6bDateAnnee");
        public final static Property Q7DateNaissanceJour = new Property(14, Short.class, "q7DateNaissanceJour", false, "q7DateNaissanceJour");
        public final static Property Q7DateNaissanceMois = new Property(15, Short.class, "q7DateNaissanceMois", false, "q7DateNaissanceMois");
        public final static Property Q7DateNaissanceAnnee = new Property(16, String.class, "q7DateNaissanceAnnee", false, "q7DateNaissanceAnnee");
        public final static Property Q8Age = new Property(17, Short.class, "q8Age", false, "q8Age");
        public final static Property Q9LienDeParente = new Property(18, Short.class, "q9LienDeParente", false, "q9LienDeParente");
        public final static Property Qp10Nationalite = new Property(19, Short.class, "qp10Nationalite", false, "qp10Nationalite");
        public final static Property Qp10PaysNationalite = new Property(20, String.class, "qp10PaysNationalite", false, "qp10PaysNationalite");
        public final static Property Q11NiveauEtude = new Property(21, Short.class, "q11NiveauEtude", false, "q11NiveauEtude");
        public final static Property Q12StatutMatrimonial = new Property(22, Short.class, "q12StatutMatrimonial", false, "q12StatutMatrimonial");
        public final static Property Statut = new Property(23, Short.class, "statut", false, "statut");
        public final static Property IsValidated = new Property(24, Boolean.class, "isValidated", false, "isValidated");
        public final static Property IsFieldAllFilled = new Property(25, Boolean.class, "isFieldAllFilled", false, "isFieldAllFilled");
        public final static Property DateDebutCollecte = new Property(26, String.class, "dateDebutCollecte", false, "dateDebutCollecte");
        public final static Property DateFinCollecte = new Property(27, String.class, "dateFinCollecte", false, "dateFinCollecte");
        public final static Property DureeSaisie = new Property(28, Integer.class, "dureeSaisie", false, "dureeSaisie");
        public final static Property IsContreEnqueteMade = new Property(29, Boolean.class, "isContreEnqueteMade", false, "isContreEnqueteMade");
        public final static Property CodeAgentRecenceur = new Property(30, String.class, "codeAgentRecenceur", false, "codeAgentRecenceur");
    };


    public IndividuDao(DaoConfig config) {
        super(config);
    }
    
    public IndividuDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"tbl_individu\" (" + //
                "\"individuId\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: individuId
                "\"menageId\" INTEGER," + // 1: menageId
                "\"logeId\" INTEGER," + // 2: logeId
                "\"batimentId\" INTEGER," + // 3: batimentId
                "\"sdeId\" TEXT," + // 4: sdeId
                "\"q1NoOrdre\" INTEGER," + // 5: q1NoOrdre
                "\"qp2APrenom\" TEXT," + // 6: qp2APrenom
                "\"qp2BNom\" TEXT," + // 7: qp2BNom
                "\"qp4Sexe\" INTEGER," + // 8: qp4Sexe
                "\"q5EstMembreMenage\" INTEGER," + // 9: q5EstMembreMenage
                "\"q6aMembreMenageDepuisQuand\" INTEGER," + // 10: q6aMembreMenageDepuisQuand
                "\"q6bDateJour\" INTEGER," + // 11: q6bDateJour
                "\"q6bDateMois\" INTEGER," + // 12: q6bDateMois
                "\"q6bDateAnnee\" TEXT," + // 13: q6bDateAnnee
                "\"q7DateNaissanceJour\" INTEGER," + // 14: q7DateNaissanceJour
                "\"q7DateNaissanceMois\" INTEGER," + // 15: q7DateNaissanceMois
                "\"q7DateNaissanceAnnee\" TEXT," + // 16: q7DateNaissanceAnnee
                "\"q8Age\" INTEGER," + // 17: q8Age
                "\"q9LienDeParente\" INTEGER," + // 18: q9LienDeParente
                "\"qp10Nationalite\" INTEGER," + // 19: qp10Nationalite
                "\"qp10PaysNationalite\" TEXT," + // 20: qp10PaysNationalite
                "\"q11NiveauEtude\" INTEGER," + // 21: q11NiveauEtude
                "\"q12StatutMatrimonial\" INTEGER," + // 22: q12StatutMatrimonial
                "\"statut\" INTEGER," + // 23: statut
                "\"isValidated\" INTEGER," + // 24: isValidated
                "\"isFieldAllFilled\" INTEGER," + // 25: isFieldAllFilled
                "\"dateDebutCollecte\" TEXT," + // 26: dateDebutCollecte
                "\"dateFinCollecte\" TEXT," + // 27: dateFinCollecte
                "\"dureeSaisie\" INTEGER," + // 28: dureeSaisie
                "\"isContreEnqueteMade\" INTEGER," + // 29: isContreEnqueteMade
                "\"codeAgentRecenceur\" TEXT);"); // 30: codeAgentRecenceur
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"tbl_individu\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Individu entity) {
        stmt.clearBindings();
 
        Long individuId = entity.getIndividuId();
        if (individuId != null) {
            stmt.bindLong(1, individuId);
        }
 
        Long menageId = entity.getMenageId();
        if (menageId != null) {
            stmt.bindLong(2, menageId);
        }
 
        Long logeId = entity.getLogeId();
        if (logeId != null) {
            stmt.bindLong(3, logeId);
        }
 
        Long batimentId = entity.getBatimentId();
        if (batimentId != null) {
            stmt.bindLong(4, batimentId);
        }
 
        String sdeId = entity.getSdeId();
        if (sdeId != null) {
            stmt.bindString(5, sdeId);
        }
 
        Short q1NoOrdre = entity.getQ1NoOrdre();
        if (q1NoOrdre != null) {
            stmt.bindLong(6, q1NoOrdre);
        }
 
        String qp2APrenom = entity.getQp2APrenom();
        if (qp2APrenom != null) {
            stmt.bindString(7, qp2APrenom);
        }
 
        String qp2BNom = entity.getQp2BNom();
        if (qp2BNom != null) {
            stmt.bindString(8, qp2BNom);
        }
 
        Short qp4Sexe = entity.getQp4Sexe();
        if (qp4Sexe != null) {
            stmt.bindLong(9, qp4Sexe);
        }
 
        Short q5EstMembreMenage = entity.getQ5EstMembreMenage();
        if (q5EstMembreMenage != null) {
            stmt.bindLong(10, q5EstMembreMenage);
        }
 
        Short q6aMembreMenageDepuisQuand = entity.getQ6aMembreMenageDepuisQuand();
        if (q6aMembreMenageDepuisQuand != null) {
            stmt.bindLong(11, q6aMembreMenageDepuisQuand);
        }
 
        Short q6bDateJour = entity.getQ6bDateJour();
        if (q6bDateJour != null) {
            stmt.bindLong(12, q6bDateJour);
        }
 
        Short q6bDateMois = entity.getQ6bDateMois();
        if (q6bDateMois != null) {
            stmt.bindLong(13, q6bDateMois);
        }
 
        String q6bDateAnnee = entity.getQ6bDateAnnee();
        if (q6bDateAnnee != null) {
            stmt.bindString(14, q6bDateAnnee);
        }
 
        Short q7DateNaissanceJour = entity.getQ7DateNaissanceJour();
        if (q7DateNaissanceJour != null) {
            stmt.bindLong(15, q7DateNaissanceJour);
        }
 
        Short q7DateNaissanceMois = entity.getQ7DateNaissanceMois();
        if (q7DateNaissanceMois != null) {
            stmt.bindLong(16, q7DateNaissanceMois);
        }
 
        String q7DateNaissanceAnnee = entity.getQ7DateNaissanceAnnee();
        if (q7DateNaissanceAnnee != null) {
            stmt.bindString(17, q7DateNaissanceAnnee);
        }
 
        Short q8Age = entity.getQ8Age();
        if (q8Age != null) {
            stmt.bindLong(18, q8Age);
        }
 
        Short q9LienDeParente = entity.getQ9LienDeParente();
        if (q9LienDeParente != null) {
            stmt.bindLong(19, q9LienDeParente);
        }
 
        Short qp10Nationalite = entity.getQp10Nationalite();
        if (qp10Nationalite != null) {
            stmt.bindLong(20, qp10Nationalite);
        }
 
        String qp10PaysNationalite = entity.getQp10PaysNationalite();
        if (qp10PaysNationalite != null) {
            stmt.bindString(21, qp10PaysNationalite);
        }
 
        Short q11NiveauEtude = entity.getQ11NiveauEtude();
        if (q11NiveauEtude != null) {
            stmt.bindLong(22, q11NiveauEtude);
        }
 
        Short q12StatutMatrimonial = entity.getQ12StatutMatrimonial();
        if (q12StatutMatrimonial != null) {
            stmt.bindLong(23, q12StatutMatrimonial);
        }
 
        Short statut = entity.getStatut();
        if (statut != null) {
            stmt.bindLong(24, statut);
        }
 
        Boolean isValidated = entity.getIsValidated();
        if (isValidated != null) {
            stmt.bindLong(25, isValidated ? 1L: 0L);
        }
 
        Boolean isFieldAllFilled = entity.getIsFieldAllFilled();
        if (isFieldAllFilled != null) {
            stmt.bindLong(26, isFieldAllFilled ? 1L: 0L);
        }
 
        String dateDebutCollecte = entity.getDateDebutCollecte();
        if (dateDebutCollecte != null) {
            stmt.bindString(27, dateDebutCollecte);
        }
 
        String dateFinCollecte = entity.getDateFinCollecte();
        if (dateFinCollecte != null) {
            stmt.bindString(28, dateFinCollecte);
        }
 
        Integer dureeSaisie = entity.getDureeSaisie();
        if (dureeSaisie != null) {
            stmt.bindLong(29, dureeSaisie);
        }
 
        Boolean isContreEnqueteMade = entity.getIsContreEnqueteMade();
        if (isContreEnqueteMade != null) {
            stmt.bindLong(30, isContreEnqueteMade ? 1L: 0L);
        }
 
        String codeAgentRecenceur = entity.getCodeAgentRecenceur();
        if (codeAgentRecenceur != null) {
            stmt.bindString(31, codeAgentRecenceur);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Individu readEntity(Cursor cursor, int offset) {
        Individu entity = new Individu( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // individuId
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // menageId
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // logeId
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // batimentId
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // sdeId
            cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5), // q1NoOrdre
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // qp2APrenom
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // qp2BNom
            cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8), // qp4Sexe
            cursor.isNull(offset + 9) ? null : cursor.getShort(offset + 9), // q5EstMembreMenage
            cursor.isNull(offset + 10) ? null : cursor.getShort(offset + 10), // q6aMembreMenageDepuisQuand
            cursor.isNull(offset + 11) ? null : cursor.getShort(offset + 11), // q6bDateJour
            cursor.isNull(offset + 12) ? null : cursor.getShort(offset + 12), // q6bDateMois
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // q6bDateAnnee
            cursor.isNull(offset + 14) ? null : cursor.getShort(offset + 14), // q7DateNaissanceJour
            cursor.isNull(offset + 15) ? null : cursor.getShort(offset + 15), // q7DateNaissanceMois
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // q7DateNaissanceAnnee
            cursor.isNull(offset + 17) ? null : cursor.getShort(offset + 17), // q8Age
            cursor.isNull(offset + 18) ? null : cursor.getShort(offset + 18), // q9LienDeParente
            cursor.isNull(offset + 19) ? null : cursor.getShort(offset + 19), // qp10Nationalite
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // qp10PaysNationalite
            cursor.isNull(offset + 21) ? null : cursor.getShort(offset + 21), // q11NiveauEtude
            cursor.isNull(offset + 22) ? null : cursor.getShort(offset + 22), // q12StatutMatrimonial
            cursor.isNull(offset + 23) ? null : cursor.getShort(offset + 23), // statut
            cursor.isNull(offset + 24) ? null : cursor.getShort(offset + 24) != 0, // isValidated
            cursor.isNull(offset + 25) ? null : cursor.getShort(offset + 25) != 0, // isFieldAllFilled
            cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26), // dateDebutCollecte
            cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27), // dateFinCollecte
            cursor.isNull(offset + 28) ? null : cursor.getInt(offset + 28), // dureeSaisie
            cursor.isNull(offset + 29) ? null : cursor.getShort(offset + 29) != 0, // isContreEnqueteMade
            cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30) // codeAgentRecenceur
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Individu entity, int offset) {
        entity.setIndividuId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMenageId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setLogeId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setBatimentId(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setSdeId(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setQ1NoOrdre(cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5));
        entity.setQp2APrenom(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setQp2BNom(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setQp4Sexe(cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8));
        entity.setQ5EstMembreMenage(cursor.isNull(offset + 9) ? null : cursor.getShort(offset + 9));
        entity.setQ6aMembreMenageDepuisQuand(cursor.isNull(offset + 10) ? null : cursor.getShort(offset + 10));
        entity.setQ6bDateJour(cursor.isNull(offset + 11) ? null : cursor.getShort(offset + 11));
        entity.setQ6bDateMois(cursor.isNull(offset + 12) ? null : cursor.getShort(offset + 12));
        entity.setQ6bDateAnnee(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setQ7DateNaissanceJour(cursor.isNull(offset + 14) ? null : cursor.getShort(offset + 14));
        entity.setQ7DateNaissanceMois(cursor.isNull(offset + 15) ? null : cursor.getShort(offset + 15));
        entity.setQ7DateNaissanceAnnee(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setQ8Age(cursor.isNull(offset + 17) ? null : cursor.getShort(offset + 17));
        entity.setQ9LienDeParente(cursor.isNull(offset + 18) ? null : cursor.getShort(offset + 18));
        entity.setQp10Nationalite(cursor.isNull(offset + 19) ? null : cursor.getShort(offset + 19));
        entity.setQp10PaysNationalite(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setQ11NiveauEtude(cursor.isNull(offset + 21) ? null : cursor.getShort(offset + 21));
        entity.setQ12StatutMatrimonial(cursor.isNull(offset + 22) ? null : cursor.getShort(offset + 22));
        entity.setStatut(cursor.isNull(offset + 23) ? null : cursor.getShort(offset + 23));
        entity.setIsValidated(cursor.isNull(offset + 24) ? null : cursor.getShort(offset + 24) != 0);
        entity.setIsFieldAllFilled(cursor.isNull(offset + 25) ? null : cursor.getShort(offset + 25) != 0);
        entity.setDateDebutCollecte(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
        entity.setDateFinCollecte(cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27));
        entity.setDureeSaisie(cursor.isNull(offset + 28) ? null : cursor.getInt(offset + 28));
        entity.setIsContreEnqueteMade(cursor.isNull(offset + 29) ? null : cursor.getShort(offset + 29) != 0);
        entity.setCodeAgentRecenceur(cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Individu entity, long rowId) {
        entity.setIndividuId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Individu entity) {
        if(entity != null) {
            return entity.getIndividuId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
