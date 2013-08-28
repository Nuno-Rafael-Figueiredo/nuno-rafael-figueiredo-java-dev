package employees.model;

import mysql.Column;
import mysql.Table;
import mysql.dataTypes.Int;

/**
 * Created with IntelliJ IDEA.
 * User: Nuno
 * Date: 28-08-2013
 * Time: 21:12
 * To change this template use File | Settings | File Templates.
 */
public class Salaries extends Table {
    private Salaries(){
    }

    public Column id(){
        return createColumn("id", new Int(), Column.Property.primaryKey);
    }

    public Column value(){
        return createColumn("value", new Int(), Column.Property.notNull);
    }

    public Column fromDate(){
        return createColumn("from_date", new Int(), Column.Property.notNull);
    }
}
