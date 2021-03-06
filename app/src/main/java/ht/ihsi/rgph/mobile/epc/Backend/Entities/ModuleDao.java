package ht.ihsi.rgph.mobile.epc.Backend.Entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import ht.ihsi.rgph.mobile.epc.Backend.Entities.Module;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "tbl_module".
*/
public class ModuleDao extends AbstractDao<Module, Void> {

    public static final String TABLENAME = "tbl_module";

    /**
     * Properties of entity Module.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property CodeModule = new Property(0, String.class, "codeModule", false, "codeModule");
        public final static Property NomModule = new Property(1, String.class, "nomModule", false, "nomModule");
        public final static Property TypeModule = new Property(2, Integer.class, "typeModule", false, "typeModule");
        public final static Property Description = new Property(3, String.class, "description", false, "description");
        public final static Property EstActif = new Property(4, Boolean.class, "estActif", false, "estActif");
    };


    public ModuleDao(DaoConfig config) {
        super(config);
    }
    
    public ModuleDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"tbl_module\" (" + //
                "\"codeModule\" TEXT NOT NULL UNIQUE ," + // 0: codeModule
                "\"nomModule\" TEXT," + // 1: nomModule
                "\"typeModule\" INTEGER," + // 2: typeModule
                "\"description\" TEXT," + // 3: description
                "\"estActif\" INTEGER);"); // 4: estActif
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_tbl_module_codeModule ON tbl_module" +
                " (\"codeModule\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"tbl_module\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Module entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getCodeModule());
 
        String nomModule = entity.getNomModule();
        if (nomModule != null) {
            stmt.bindString(2, nomModule);
        }
 
        Integer typeModule = entity.getTypeModule();
        if (typeModule != null) {
            stmt.bindLong(3, typeModule);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(4, description);
        }
 
        Boolean estActif = entity.getEstActif();
        if (estActif != null) {
            stmt.bindLong(5, estActif ? 1L: 0L);
        }
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public Module readEntity(Cursor cursor, int offset) {
        Module entity = new Module( //
            cursor.getString(offset + 0), // codeModule
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // nomModule
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // typeModule
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // description
            cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0 // estActif
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Module entity, int offset) {
        entity.setCodeModule(cursor.getString(offset + 0));
        entity.setNomModule(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTypeModule(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setDescription(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setEstActif(cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0);
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(Module entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(Module entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
