package employees.model;

import mysql.Column;
import mysql.Table;
import mysql.dataTypes.Date;
import mysql.dataTypes.Int;

/**
 * User: Nuno
 * Date: 28-08-2013
 * Time: 21:12
 */
public class Salaries extends Table {
    private Salaries(){
    }

    public Column idEmployee(){
        return createForeignKey(Employees.INSTANCE, Column.Property.primaryKey);
    }

    public Column fromDate(){
        return createColumn("from_date", new Date(), Column.Property.primaryKey);
    }

    public Column value(){
        return createColumn("value", new Int(), Column.Property.notNull);
    }

    public Column toDate(){
        return createColumn("to_date", new Date(), Column.Property.notNull);
    }
}
