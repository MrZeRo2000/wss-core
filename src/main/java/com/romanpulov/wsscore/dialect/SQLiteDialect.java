package com.romanpulov.wsscore.dialect;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;

import java.sql.Types;

/**
 * SQLite database dialect
 * https://www.baeldung.com/spring-boot-sqlite
 * https://github.com/bharat0126/springboot-sqlite-app/tree/master/sqlite-db-sample/src/main/java/com/sqlite
 */
public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        registerColumnType(Types.BIT, "integer");
        registerColumnType(Types.TINYINT, "tinyint");
        registerColumnType(Types.SMALLINT, "smallint");
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.BIGINT, "bigint");
        registerColumnType(Types.FLOAT, "float");
        registerColumnType(Types.REAL, "real");
        registerColumnType(Types.DOUBLE, "double");
        registerColumnType(Types.NUMERIC, "numeric");
        registerColumnType(Types.DECIMAL, "decimal");
        registerColumnType(Types.CHAR, "char");
        registerColumnType(Types.VARCHAR, "varchar");
        registerColumnType(Types.LONGVARCHAR, "longvarchar");
        registerColumnType(Types.DATE, "date");
        registerColumnType(Types.TIME, "time");
        registerColumnType(Types.TIMESTAMP, "timestamp");
        registerColumnType(Types.BINARY, "blob");
        registerColumnType(Types.VARBINARY, "blob");
        registerColumnType(Types.LONGVARBINARY, "blob");
        registerColumnType(Types.BLOB, "blob");
        registerColumnType(Types.CLOB, "clob");
        registerColumnType(Types.BOOLEAN, "integer");
    }

    public IdentityColumnSupport getIdentityColumnSupport() {
        return new SQLiteIdentityColumnSupport();
    }

    public boolean hasAlterTable() {
        return false;
    }

    public boolean dropConstraints() {
        return false;
    }

    public String getDropForeignKeyString() {
        throw new UnsupportedOperationException("No drop foreign key syntax supported by SQLiteDialect");
    }

    public String getAddForeignKeyConstraintString(String constraintName, String[] foreignKey, String referencedTable, String[] primaryKey, boolean referencesPrimaryKey) {
        throw new UnsupportedOperationException("No add foreign key syntax supported by SQLiteDialect");
    }

    public String getAddPrimaryKeyConstraintString(String constraintName) {
        throw new UnsupportedOperationException("No add primary key syntax supported by SQLiteDialect");
    }

    public String getForUpdateString() {
        return "";
    }

    public String getAddColumnString() {
        return "add column";
    }

    public boolean supportsOuterJoinForUpdate() {
        return false;
    }

    public boolean supportsIfExistsBeforeTableName() {
        return true;
    }

    public boolean supportsCascadeDelete() {
        return false;
    }
}