package employees.model;

import mysql.Column;
import mysql.Table;
import mysql.dataTypes.Int;

/**
 * User: Nuno
 * Date: 28-08-2013
 * Time: 21:12
 */
public class Employees extends Table {
    public static final Employees INSTANCE = new Employees();

    private final PrimaryKey primaryKey = new PrimaryKey();

    private Employees(){
    }

    public PrimaryKey primaryKey(){
        primaryKey.set(createColumn("id", new Int(), Column.Property.autoIncrement, Column.Property.primaryKey));
        return primaryKey;
    }

}
