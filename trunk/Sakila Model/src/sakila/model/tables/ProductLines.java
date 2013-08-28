package sakila.model.tables;

import mysql.Column;
import mysql.Table;
import mysql.dataTypes.Varchar;

/**
 * User: Nuno
 * Date: 28-08-2013
 * Time: 15:46
 */
public class ProductLines extends Table {
    public Column productLine(){
        return createColumn("productLine", new Varchar(50), Column.Property.notNull, Column.Property.primaryKey);
    }
}
